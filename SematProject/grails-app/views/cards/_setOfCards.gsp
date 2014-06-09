
<!-- CSS -->
  <style>
    .container {
      border: 1px dashed #CCC;
      position: relative;
    }

    .container > div {

      position: absolute;
      height: 280px;
      width: 215px;
    }

    .container > .ss-placeholder-child {
      background: transparent;
      border: 1px dashed blue;
    }
  </style>

  <!-- Javascript -->
  <script>
    $(document).ready(function() {
      $(".container").shapeshift();
    })
  </script>
</head>
<body>
<div id="jquery-script-menu">
<div class="jquery-script-center">

<div class="jquery-script-ads"><script type="text/javascript"><!--
google_ad_client = "ca-pub-2783044520727903";
/* jQuery_demo */
google_ad_slot = "2780937993";
google_ad_width = 728;
google_ad_height = 90;
//-->
</script>
</div>
<div class="jquery-script-clear"></div>
</div>
</div>

  <div class="container">
    <div><div id ="greenCard"><g:render template="/cards/cardG1"/></div></div>
    <div><div id ="card"><g:render template="/cards/cardB1"/></div></div>
    <div><div id ="card"><g:render template="/cards/cardB2"/></div></div>

    <div></div>
    

  </div>
  
  

  <div class="container">
	<div><div id ="yellowCard"><g:render template="/cards/ycard"/></div></div>
    <div><div id ="yellowCard"><g:render template="/cards/ycard"/></div></div>
    <div><div id ="yellowCard"><g:render template="/cards/ycard"/></div></div>
    <div></div>
 </div>
 

 