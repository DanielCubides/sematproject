package sematproject



import org.junit.*
import grails.test.mixin.*

@TestFor(KernelController)
@Mock(Kernel)
class KernelControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/kernel/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.kernelInstanceList.size() == 0
        assert model.kernelInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.kernelInstance != null
    }

    void testSave() {
        controller.save()

        assert model.kernelInstance != null
        assert view == '/kernel/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/kernel/show/1'
        assert controller.flash.message != null
        assert Kernel.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/kernel/list'

        populateValidParams(params)
        def kernel = new Kernel(params)

        assert kernel.save() != null

        params.id = kernel.id

        def model = controller.show()

        assert model.kernelInstance == kernel
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/kernel/list'

        populateValidParams(params)
        def kernel = new Kernel(params)

        assert kernel.save() != null

        params.id = kernel.id

        def model = controller.edit()

        assert model.kernelInstance == kernel
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/kernel/list'

        response.reset()

        populateValidParams(params)
        def kernel = new Kernel(params)

        assert kernel.save() != null

        // test invalid parameters in update
        params.id = kernel.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/kernel/edit"
        assert model.kernelInstance != null

        kernel.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/kernel/show/$kernel.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        kernel.clearErrors()

        populateValidParams(params)
        params.id = kernel.id
        params.version = -1
        controller.update()

        assert view == "/kernel/edit"
        assert model.kernelInstance != null
        assert model.kernelInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/kernel/list'

        response.reset()

        populateValidParams(params)
        def kernel = new Kernel(params)

        assert kernel.save() != null
        assert Kernel.count() == 1

        params.id = kernel.id

        controller.delete()

        assert Kernel.count() == 0
        assert Kernel.get(kernel.id) == null
        assert response.redirectedUrl == '/kernel/list'
    }
}
