<%@ include file="../common/init.jsp"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<html>
  <head>
    <sj:head jqueryui="true" jquerytheme="redmond" />
  </head>
  <body>
    <s:url id="remoteurl" action="demoAction"/>
    <sjg:grid
        id="gridtable"
        caption="Grid Examples"
        dataType="json"
        href="%{remoteurl}"
        pager="true"
        gridModel="data.gridModel"
        rowList="10,15,20"
        rowNum="15"
        rownumbers="true"
        onSelectRowTopics="rowselect"
    >
        <sjg:gridColumn name="id" index="id" title="ID" formatter="integer" sortable="false"/>
        <sjg:gridColumn name="title" index="title" title="Title" sortable="true"/>
        <sjg:gridColumn name="content" index="content" title="Content" sortable="false"/>
        <sjg:gridColumn name="publishdate" index="publishdate" title="Publishdate" sortable="true"/>
    </sjg:grid>
    
    <script type="text/javascript">
		$.subscribe('rowselect', function(event, data) {
        	alert('Selected Row : ' + event.originalEvent.id);
		});
	</script>
  </body>
</html>