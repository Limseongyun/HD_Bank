<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<div class="content">
				<!-- ����� Ǫ���� ���� ���� -->
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">������</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="" class="btn btn-white btn-sm btn-border mr-1">1:1�����ϱ�</a>
								 </h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">���� ������</a>
								<a href="qna" class="btn btn-secondary btn-round">������</a>
							</div>
						</div>
					</div>
				</div>
				<!-- ����� Ǫ���� ���� �� -->
				<div class="page-inner mt--5">
				<!-- ������ ���̾ƿ� ���� -->
				<div class="row row-card-no-pd">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="card-head-row card-tools-still-right">
										<h4 class="card-title">1��1����</h4>
									</div>
								</div>
								
								<div class="card-body">
									<div class="row">
										<div class="col-11">
											<table class="table mt-1">
											<tbody>
												<tr>
													<th scope="col">
														*���� ī�װ�
													</th>
													<td>
														<div class="row">
															<div class="col-7">
																<select class="form-control" id="exampleFormControlSelect1">
																	<option>���� �з�����</option>
																	<option>??</option>
																</select>
															</div>
															
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">�̸���</th>
													<td>
														<div class="row">
															<div class="col-8">
																<input type="text" class="form-control input-full">                                      
															</div>
														</div>
													</td>
												</tr>
												
												<tr>
													<th scope="col">��ȭ��ȣ</th>
													<td>
														<div class="row">
															<div class="col-2">
																<select class="form-control" id="exampleFormControlSelect1">
																	<option>02</option>
																	<option>032</option>
																	<option>063</option>
																</select>
															</div>
															<div class="col-2">
																<input type="text" class="form-control input-full">
															</div>
															<div class="col-2">
																<input type="text" class="form-control input-full">
															</div>
														</div>
													</td>
												</tr>
												
												
												<tr>
													<th scope="col">�޴���</th>
													<td>
														<div class="row">
															<div class="col-2">
																<select class="form-control" id="exampleFormControlSelect1">
																	<option>011</option>
																	<option>010</option>
																</select>
															</div>
															<div class="col-2">
																<input type="text" class="form-control input-full">
															</div>
															<div class="col-2">
																<input type="text" class="form-control input-full">
															</div>
														</div>
													</td>
												</tr>
								
												<tr>
													<th scope="col">*��������</th>
													<td>
														<div class="row">
															<div class="col-8">
																<input type="text" class="form-control input-full">                                      
															</div>
														</div>
													</td>
												</tr>
												<tr>
													<th scope="col">*��������</th>
													<td>
														<div class="row">
															<div style="width: 400px;">
																<input type="text" class="form-control input-full" placeholder="�������Է����ּ���."
																>
															</div>
														</div>
													</td>
												</tr>
											</tbody>
											<tfoot>
												<tr>
													<th colspan="2">
														<div class="row">
															<div class="col-md-6 ml-auto mr-auto">
																<button class="btn btn-danger" id="cancel">���</button>
																<button class="btn btn-success" id="send">Ȯ��</button>
															</div>
														</div>
													</th>
												</tr>
											</tfoot>
										</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- ������ ���̾ƿ� �� -->
				</div>
			</div>


			
			
			<script>
			$("#cancel").click(function() {
				location = "security";
			});
			$("#send").click(function() {
				location = "securitycardsuccess";
			});
			$('#emailsend').click(function(e) {
				swal({
					title: '�̸����� ���� �Ͻðڽ��ϱ�?',
					text: "�̸����� Ȯ�����ּ���. \n hani@naver.com",
					type: 'warning',
					buttons:{
						confirm: {
							text : '����',
							className : 'btn btn-success'
						},
						cancel: {
							text : '���',
							visible: true,
							className: 'btn btn-danger'
						}
					}
				}).then((Delete) => {
					if (Delete) {
						swal({
							title: '���۵Ǿ����ϴ�.',
							text: '���۵� �ڵ带 �Է����ּ���.',
							type: 'success',
							buttons : {
								confirm: {
									text : 'Ȯ��',
									className : 'btn btn-success'
								}
							}
						});
					} else {
						swal.close();
					}
				});
			});
			
		Circles.create({
			id:'circles-1',
			radius:45,
			value:60,
			maxValue:100,
			width:7,
			text: 5,
			colors:['#f1f1f1', '#FF9E27'],
			duration:400,
			wrpClass:'circles-wrp',
			textClass:'circles-text',
			styleWrapper:true,
			styleText:true
		})

		Circles.create({
			id:'circles-2',
			radius:45,
			value:70,
			maxValue:100,
			width:7,
			text: 36,
			colors:['#f1f1f1', '#2BB930'],
			duration:400,
			wrpClass:'circles-wrp',
			textClass:'circles-text',
			styleWrapper:true,
			styleText:true
		})

		Circles.create({
			id:'circles-3',
			radius:45,
			value:40,
			maxValue:100,
			width:7,
			text: 12,
			colors:['#f1f1f1', '#F25961'],
			duration:400,
			wrpClass:'circles-wrp',
			textClass:'circles-text',
			styleWrapper:true,
			styleText:true
		})

		var totalIncomeChart = document.getElementById('totalIncomeChart').getContext('2d');

		var mytotalIncomeChart = new Chart(totalIncomeChart, {
			type: 'bar',
			data: {
				labels: ["S", "M", "T", "W", "T", "F", "S", "S", "M", "T"],
				datasets : [{
					label: "Total Income",
					backgroundColor: '#ff9e27',
					borderColor: 'rgb(23, 125, 255)',
					data: [6, 4, 9, 5, 4, 6, 4, 3, 8, 10],
				}],
			},
			options: {
				responsive: true,
				maintainAspectRatio: false,
				legend: {
					display: false,
				},
				scales: {
					yAxes: [{
						ticks: {
							display: false //this will remove only the label
						},
						gridLines : {
							drawBorder: false,
							display : false
						}
					}],
					xAxes : [ {
						gridLines : {
							drawBorder: false,
							display : false
						}
					}]
				},
			}
		});

		$('#lineChart').sparkline([105,103,123,100,95,105,115], {
			type: 'line',
			height: '70',
			width: '100%',
			lineWidth: '2',
			lineColor: '#ffa534',
			fillColor: 'rgba(255, 165, 52, .14)'
		});
	</script>
