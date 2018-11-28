<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="sidebar-nav nav-collapse collapse">
	<div class="user_side clearfix">
		<img src="${pageContext.request.contextPath}/Content/img/odinn.jpg"
			alt="Odinn god of Thunder">
		<h5>${currentOperator.wk_no}</h5>
		<h5>${currentOperator.oname}</h5>
	</div>
	<div class="accordion" id="accordion2">
		<c:forEach items="${menuTree}" var="tree">
			<c:if test="${tree.t_level==1}">
				<div class="accordion-group">
					<div class="accordion-heading">
						<a id="${tree.id}" class="accordion-toggle b_C3F7A7 collapsed"
							data-toggle="collapse" data-parent="#accordion2"
							href="#collapseid_${tree.id}"><i class="icon-reorder"></i> <span>${tree.mname}</span></a>
					</div>
					<div id="collapseid_${tree.id}" class="accordion-body collapse">
						<div class="accordion-inner">
							<c:forEach items="${menuTree}" var="inTree">
								<c:if test="${inTree.parentid==tree.id}">
									<a id="${inTree.id}" class="accordion-toggle"
										href="${pageContext.request.contextPath}/${inTree.url}?treeid=${tree.id}&inTreeid=${inTree.id}">
										<i class="icon-caret-right"></i> ${inTree.mname}</a>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${tree.t_level==0}">
				<div class="accordion-group">
					<div class="accordion-heading">
						<a id="${tree.id}" class="accordion-toggle b_F6F1A2"
							href="${pageContext.request.contextPath}/${tree.url}?treeid=${tree.id}">
							<i class="icon-reorder"></i> <span>${tree.mname}</span></a>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</div>
</div>

<script type="text/javascript">
	function GetQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) {
			return unescape(r[2]);
		} else {
			return null;
		}
	}
	var treeid = GetQueryString("treeid");
	var inTreeid = GetQueryString("inTreeid");
	var collapse = "collapseid_" + treeid;
	function addTreeClass() {
		$("#" + treeid).addClass("active");
		$("#" + inTreeid).addClass("active");
		$("#" + collapse).css({"height" : "auto"});
		$("#" + treeid).removeClass("collapsed");
	}
	$(addTreeClass());
</script>