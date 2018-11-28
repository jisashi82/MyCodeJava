<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>

<div class="card clearfix">

	<div class="card-header">
		<h3 class="float-left">	<jsp:invoke fragment="header" /> </h3>
	</div>

	<div class="card-body">
		<jsp:doBody />
	</div>

	<div class="card-footer my-1"></div>
</div>
