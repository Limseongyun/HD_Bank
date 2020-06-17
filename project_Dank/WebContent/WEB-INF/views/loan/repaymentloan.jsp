<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
			<div class="content">	
	<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">����</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="check" class="btn btn-white btn-sm btn-border mr-1">������Ȳ ��ȸ</a>
								 </h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">���� ������</a>
								<a href="qna" class="btn btn-secondary btn-round">��������</a>
							</div>
						</div>
					</div>
				</div>
				<!--���� ��û ��ȸ  -->
				<form action="loanrepay" method="post">
				
				<div class="row mt--4">
				<div class="col-sm-6 col-md-2"></div>
						<div class="col-sm-6 col-md-8">
								<div class="card card-stats card-round">
								
									<div class="card-body ">
										<div class="row">
										<h2>&nbsp;&nbsp;&nbsp;&nbsp;���� ����</h2>
											<table class="table table-hover">
												
													<tr>
														<th>�����</th>
														<td><input type="text" readonly="readonly" name="lp_name" value="${vo.loanProductVO.lp_name }"> </td>
													</tr>
													<tr>
														<th>�����ȣ</th>
														<td><input type="text" name="lc_num" value="${vo.lc_num }" readonly="readonly"> </td>
													</tr>
													<tr>
														<th>��������</th>
														<td><input type="text" readonly="readonly" value="${vo.loanProductVO.lp_interestrate }"></td>
													</tr>	
													<tr>
														<th>�����û��</th>
														<td><input type="text" readonly="readonly" value="${vo.loanApplicationVO.la_hamount }"></td>
													</tr>
													<tr>
														<th>��ġ�Ⱓ</th>
														<td><input type="text" readonly="readonly" value="${vo.loanApplicationVO.la_livingterm }"></td>
													</tr>
													<tr>
														<th>��ȯ�Ⱓ</th>
														<td><input type="text" readonly="readonly" value="${vo.loanApplicationVO.la_repayterm }"></td>
													</tr>
													<tr>
														<th>��ȯ����</th>
														<td>
														<select name="ac_num" id="ac_num">
														<c:forEach items="${list }" var="e">
															<option>${e.ac_num }</option>
														</c:forEach>
														</select>
														</td>
													</tr>
													<tr>
														<th>��ȯ�ݾ�</th>
														<td><input type="number" name="lr_balance"></td>
													</tr>	
													<tr>
														<td colspan="2">
											<p class="text-center"><button type="submit" class="btn btn-lg btn-primary repay" value="${vo.lc_num }">��ȯ�ϱ�</button></p>
														
														</td>
													</tr>	
												
											</table>

										
										</div>
									</div>
								</div>
							</div>
		<div class="col-sm-6 col-md-2">
		</div>
			
						</div>
		</form>
		
		
			</div>
		
			

			
			
			<script>
		
	
	</script>
