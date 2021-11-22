<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>CKEditor</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<!-- Ckeditor script 추가  -->
		<script src="https://cdn.ckeditor.com/ckeditor5/30.0.0/classic/ckeditor.js"></script>
		<script src="https://ckeditor.com/apps/ckfinder/3.5.0/ckfinder.js"></script>
		
		<style>
			.ck-editor__editable_inline {
			    min-height: 600px;
			}
		</style>
	</head>
	<body class="is-preload">
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

						<!-- Header -->
							<header id="header">
								<a href="#" class="logo"><strong>CKEditor</strong></a>
							</header>

						<!-- Section -->
							<section style="padding-top: 35px;">
								<!-- 게시글 입력 Form -->
								<form method="post" action="insertBoard.do" name="form1">
	
									<h2><span>Title : </span><input type="text" name="title" id="title" required="required" style="width: 90%;"></h2>
									<!-- CKEditor -->
									<textarea name="content" id="editor"></textarea>
									<input type="button" value="write" onclick="send()" class="button" style="float: right;">
								</form>
							</section>
						</div>
					</div>
			</div>
	</body>

<script type="text/javascript">
	function send() {
		if ($('#title').val() == '' || $('#title').val() == null ) {
			alert('제목을 입력해주세요.');
			$('#title').focus();
			return;
		}
		if ($('.ck-content').text() == '') {
			alert('내용을 입력해주세요.');
			$('.ck-content').focus();
			return;
		}
		document.form1.submit();
	}

	// CKEditor5를 생성할 textarea
	ClassicEditor.create( document.querySelector('#editor'),{
		language: "ko",
		ckfinder: {
  	      uploadUrl: 'fileupload.do'
		},
		alignment: {
     	   options: [ 'left', 'center', 'right' ]
	   	 },
  	 	image: {
 		   	toolbar: ['toggleImageCaption','resizeImage']
  	 	}
		})
	.then( editor => {
 	   console.log( 'Editor was initialized', editor ); 
	} )
	.catch( error => {
		console.error( error );
	} );
	</script>
</html>