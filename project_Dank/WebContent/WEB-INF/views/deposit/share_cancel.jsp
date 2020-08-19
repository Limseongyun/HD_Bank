<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<div class="content">
				<!-- ����� Ǫ���� ���� ���� -->
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">����</h2>
								<h5 class="text-white op-7 mb-2">����>�ű�>��������</h5>
							</div>
							<div class="ml-md-auto py-2 py-md-0">
								<a href="checkbalance" class="btn btn-white btn-border btn-round mr-2">���� ������</a>
								<a href="qna" class="btn btn-secondary btn-round">��������</a>
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
									<div class="row ">
										<div class="col-md-9">
											<div class="card full-height">
												<div class="card-body">
													<div class="card-title">����ݽ� ���� ��ǰ</div>
													<div class="row">
														<div class="card-category">���� ���� ����</div>
														<div class="col-md-4 ml-auto">
															<button class="btn btn-default">�����ϱ�</button>
														</div>
													</div>								
													<div class="flex-1 ml-3 pt-1">
														<h6 class="text-uppercase fw-bold mb-1">���Գ�¥ : 2020.05.31</h6>
														<h6 class="text-uppercase fw-bold mb-1">���¹�ȣ : 110-123-78999</h6>
														<h6 class="text-uppercase fw-bold mb-1">�ܾ� : 5,000,000</h6>
													</div>
													<div class="col-md-4 ml-auto">
														<p class="text-primary"><a href="#">���� ���� ���� ��ȸ</a></p>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="row ">
										<div class="col-md-9">
											<div class="card full-height">
												<div class="card-body">
													<div class="card-title">���� ���� ��ǰ</div>
													<div class="row">
														<div class="card-category">������ ����</div>
														<div class="col-md-4 ml-auto">
															<button class="btn btn-default">�����ϱ�</button>
														</div>
													</div>								
													<div class="flex-1 ml-3 pt-1">
														<h6 class="text-uppercase fw-bold mb-1">���Գ�¥ : 2020.05.31</h6>
														<h6 class="text-uppercase fw-bold mb-1">���¹�ȣ : 110-123-78999</h6>
														<h6 class="text-uppercase fw-bold mb-1">�ܾ� : 5,000,000</h6>
													</div>
													<div class="col-md-4 ml-auto">
														<p class="text-primary"><a href="#">���� ���� ���� ��ȸ</a></p>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="row ">
										<div class="col-md-9">
											<div class="card full-height">
												<div class="card-body">
													<div class="card-title">���� ���� ����ݽ� ��ǰ</div>
													<div class="row">
														<div class="card-category">���� ���� ����</div>
														<div class="col-md-4 ml-auto">
															<button class="btn btn-default">�����ϱ�</button>
														</div>
													</div>								
													<div class="flex-1 ml-3 pt-1">
														<h6 class="text-uppercase fw-bold mb-1">���Գ�¥ : 2020.05.31</h6>
														<h6 class="text-uppercase fw-bold mb-1">���¹�ȣ : 110-123-78999</h6>
														<h6 class="text-uppercase fw-bold mb-1">�ܾ� : 5,000,000</h6><br>
														<h6 class="text-uppercase fw-bold mb-1">�����ο� : 2��</h6>
														<p class="text-primary"><a href="#">�����ο� ����</a></p>
													</div>
													<div class="col-md-4 ml-auto">
														<p class="text-primary"><a href="#">���� ���� ���� ��ȸ</a></p>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!--  -->
								</div>
							</div>
						</div>
					</div>
					</div>
					<!-- ���� ������ �� -->
					
					<!-- ������ ���̾ƿ� �� -->
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