<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div class="content">
				<!-- ����� Ǫ���� ���� ���� -->
				<div class="panel-header bg-primary-gradient">
					<div class="page-inner py-5">
						<div class="d-flex align-items-left align-items-md-center flex-column flex-md-row">
							<div>
								<h2 class="text-white pb-2 fw-bold">HD Bank</h2>
								<h5 class="text-white op-7 mb-2">�������. HD Bank ���� �������Դϴ�.</h5>
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
						<div class="col-4" id="checkBalance">
							<div class="card card-stats card-primary card-round">
								<div class="card-body">
									<div class="row">
										<div class="col-5">
											<div class="icon-big text-center">
												<i class="fas fa-dollar-sign"></i>
											</div>
										</div>
										<div class="col-7 col-stats">
											<div class="numbers">
												<p class="card-category">Check balance</p>
												<h4 class="card-title">���� ��ȸ</h4>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-4" id="transfer">
							<div class="card card-stats card-info card-round">
								<div class="card-body">
									<div class="row">
										<div class="col-5">
											<div class="icon-big text-center">
												<i class="fas fa-file-invoice-dollar"></i>
											</div>
										</div>
										<div class="col-7 col-stats">
											<div class="numbers">
												<p class="card-category">Wire money</p>
												<h4 class="card-title">���� ��ü</h4>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- <div class="col-sm-6 col-md-3" id="analysis">
							<div class="card card-stats card-success card-round">
								<div class="card-body ">
									<div class="row">
										<div class="col-5">
											<div class="icon-big text-center">
												<i class="fas fa-chart-pie"></i>
											</div>
										</div>
										<div class="col-7 col-stats">
											<div class="numbers">
												<p class="card-category">Analysis</p>
												<h4 class="card-title">�м�</h4>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div> -->
						<div class="col-4" id="exchangeRate">
							<div class="card card-stats card-secondary card-round">
								<div class="card-body ">
									<div class="row">
										<div class="col-5">
											<div class="icon-big text-center">
												<i class="flaticon-success"></i>
											</div>
										</div>
										<div class="col-7 col-stats">
											<div class="numbers">
												<p class="card-category">Exchange rate</p>
												<h4 class="card-title">ȯ�� ��ȸ</h4>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				
				<div class="row row-card-no-pd">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<div class="card-head-row card-tools-still-right">
										<h4 class="card-title">�̺�Ʈ ������</h4>
										<div class="card-tools">
											<button class="btn btn-icon btn-link btn-primary btn-xs"><span class="fa fa-angle-down"></span></button>
											<button class="btn btn-icon btn-link btn-primary btn-xs btn-refresh-card"><span class="fa fa-sync-alt"></span></button>
											<button class="btn btn-icon btn-link btn-primary btn-xs"><span class="fa fa-times"></span></button>
										</div>
									</div>
									<p class="card-category"> ��翡�� �����ϴ� �������� �̺�Ʈ�� ����ּ���. </p>
								</div>
								
								<div class="card-body">
									<div class="row">
										<div class="col-md-6">
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
	
		/* ������ �̵� �ڹٽ�ũ��Ʈ ���� */
		$("#checkBalance").click(function() {
			location = "checkbalance";
		});
		$("#transfer").click(function() {
			location = "transfer";
		});
		$("#analysis").click(function() {
			location = "analysis";
		});
		$("#exchangeRate").click(function() {
			location = "exchangerate";
		});
		/* ������ �̵� �ڹٽ�ũ��Ʈ �� */
	
	</script>
