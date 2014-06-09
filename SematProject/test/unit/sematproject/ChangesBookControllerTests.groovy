package sematproject



import org.junit.*
import grails.test.mixin.*

@TestFor(ChangesBookController)
@Mock(ChangesBook)
class ChangesBookControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/changesBook/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.changesBookInstanceList.size() == 0
        assert model.changesBookInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.changesBookInstance != null
    }

    void testSave() {
        controller.save()

        assert model.changesBookInstance != null
        assert view == '/changesBook/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/changesBook/show/1'
        assert controller.flash.message != null
        assert ChangesBook.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/changesBook/list'

        populateValidParams(params)
        def changesBook = new ChangesBook(params)

        assert changesBook.save() != null

        params.id = changesBook.id

        def model = controller.show()

        assert model.changesBookInstance == changesBook
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/changesBook/list'

        populateValidParams(params)
        def changesBook = new ChangesBook(params)

        assert changesBook.save() != null

        params.id = changesBook.id

        def model = controller.edit()

        assert model.changesBookInstance == changesBook
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/changesBook/list'

        response.reset()

        populateValidParams(params)
        def changesBook = new ChangesBook(params)

        assert changesBook.save() != null

        // test invalid parameters in update
        params.id = changesBook.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/changesBook/edit"
        assert model.changesBookInstance != null

        changesBook.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/changesBook/show/$changesBook.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        changesBook.clearErrors()

        populateValidParams(params)
        params.id = changesBook.id
        params.version = -1
        controller.update()

        assert view == "/changesBook/edit"
        assert model.changesBookInstance != null
        assert model.changesBookInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/changesBook/list'

        response.reset()

        populateValidParams(params)
        def changesBook = new ChangesBook(params)

        assert changesBook.save() != null
        assert ChangesBook.count() == 1

        params.id = changesBook.id

        controller.delete()

        assert ChangesBook.count() == 0
        assert ChangesBook.get(changesBook.id) == null
        assert response.redirectedUrl == '/changesBook/list'
    }
}
