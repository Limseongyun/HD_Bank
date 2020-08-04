<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<div class="content">
				<!-- ����� Ǫ���� ���� ���� -->
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">����</h2>
								<h5 class="text-white op-7 mb-2">
								<a href="index" class="btn btn-white btn-sm btn-border mr-1"><span class="flaticon-home"/></a>
								 <span class="h2 mr-1"> > </span>
								 <a href="" class="btn btn-white btn-sm btn-border mr-1">��������</a>
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
				<div class="row">
						
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="card-head-row">
										<div class="card-title">�������� ��û</div>
									</div>
								</div>
								<div class="card-body">
									<div class="chart-container" style="min-height: 425px">
										<div class="row">
											<div class="col-md-4 ml-auto">
												<span class="h3">�Ѹ� ����</span>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<span class="h5">ȫ�浿�԰��� ��������</span>
											</div>
										</div>
											<div class="row">
												<div class="col-md-10">
													<table class="table mt-1">
														<thead>
															
														</thead>
														<tbody>
															<tr>
																<th scope="col">���� ����</th>
																<td>
																<div class="row">
																<div class="col-2">
																	<select class="form-control" id="">
																		<option>����</option>
																		<option>����</option>
																		<option>�츮</option>
																		<option>���</option>
																		<option>����</option>
																	</select>
																</div>
																<div class="col-9">
																	<input type="text" class="form-control" id="" placeholder="(-�� ���� �Է����ּ���)">
																</div>
																</div>
																</td>
															</tr>
															<tr>
																<th scope="col">���� ��ȭ��ȣ</th>
																<td>
																<div class="row">
																	<div class="col-2">
																	<select class="form-control" id="">
																		<option>skt</option>
																		<option>kt</option>
																		<option>lg</option>
																		<option>�˶���</option>
																	</select>
																	</div>
																	<div class="col-3">
																		<input type="text" class="form-control" id="" value="010">
																	</div>
																	<div class="col-3">
																		<input type="text" class="form-control" id="" >
																	</div>
																	<div class="col-3">
																		<input type="text" class="form-control" id="" >
																	</div>
																</div>
																</td>
															</tr>
															<tr>
																<th scope="col">���� �̸���</th>
																<td>
																<div class="row">
																	<div class="col-7">
																		<input type="email" class="form-control" id="" placeholder="Enter Email">
																	</div>
																</div>
																</td>
															</tr>
															<tr>
																<th scope="col">����ī�� �Ϸù�ȣ</th>
																<td>
																<div class="row">
																	<div class="col-5">
																		<input type="text" class="form-control" id="" >
																	</div>
																</div>
																</td>
															</tr>
															<tr>
																<td colspan="2">
																	<div class="row">
																		<div class="col-md-6 ml-auto mr-auto">
																			<button class="btn btn-primary" onclick="location='share_new_insert'">Ȯ��</button>	
																		</div>
																	</div>
																</td>
															</tr>
													</tbody>
												</table>
											</div>
										</div>
										<canvas id="statisticsChart"></canvas>
									</div>
									<div id="myChartLegend">
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- ���� ������ �� -->
					
				</div>
			</div>


		
			
			
			<script>
			
			
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
