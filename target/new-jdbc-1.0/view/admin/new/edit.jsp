<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new"/>
<c:url var ="NewURL" value="/admin-new"/>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">

        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-${alert}">
                                ${messageResponse}
                        </div>
                    </c:if>
                    <form id="formSubmit">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Thể loại</label>
                            <div class="col-sm-9">
                                <select class="form-control" id="categoryCode" name = "categoryCode">
                                    <c:if test="${empty model.categoryCode}">
                                        <option value ="">Chọn bài viết</option>
                                        <c:forEach var ="item" items="${categories}">
                                            <option value="${item.code}"> ${item.name} </option>
                                        </c:forEach>
                                    </c:if>

                                    <c:if test="${not empty model.categoryCode}">
                                        <c:forEach var="item" items="${categories}">
                                            <c:if test="${item.code == model.categoryCode}">
                                                <option value="${item.code}" selected ="selected"> ${item.name} </option>
                                            </c:if>
                                          <c:if test="${item.code != model.categoryCode}">
                                              <option value="${item.code}" > ${item.name} </option>
                                          </c:if>

                                        </c:forEach>
                                        <option value="">Chọn bài viết</option>
                                    </c:if>

                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tiêu đề</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="title" name="title" value="${model.title}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="thumbnail" name="thumbnail" value="${model.thumbnail}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="shortdese" name="shortdese" value="${model.shortdese}"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Nội dung</label>
                            <div class="col-sm-9">
                                <textarea rows="" cols="" id="content" name="content" style="width: 820px;height: 175px">${model.content}</textarea>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group" >
                            <div class="col-sm-12">
                                <c:if test="${not empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật bài viết" id="btnAddOrUpdateNew"/>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm bài viết" id="btnAddOrUpdateNew"/>
                                </c:if>
                            </div>
                        </div>
                        <input type="hidden" value = "" id = "id"  name = "id">
                    </form>


                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var editor = '' ;
    $(document).ready(function(){
       editor = CKEDITOR.replace('content') ;
    });
  $('#btnAddOrUpdateNew').click(function (e) {
         e.preventDefault();
         var data = {};
         var formData = $('#formSubmit').serializeArray();
         $.each(formData ,function (i , v) {
             data[""+v.name+""] =  v.value ;
             data["content"] = editor.getData();
         })
         // var title = $('#title').val() ;
         // var categoryCode = $('#categoryCode').val();
         // var thumbnail = $('#thumbnail').val();
         // var shortdese =  $('#shortdese').val();
         // var content = $('#content').val();
        var id = $('#id').val();
         if(id=="")
         {
             addNew(data);
         }else
         {
             updateNew(data);
         }
         function addNew() {
             $.ajax({
                 url:'${APIurl}',
                 type:'POST',
                 contentType:'application/json' , // clien gui len sever
                 data : JSON.stringify(data),
                 dataType : 'json',
               success: function (result) {
                   window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=insert_success";
               },
                 error:function (result) {
                     window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=orror_system";

                 }
             });
         }
         function updateNew() {
         $.ajax({
             url:'${APIurl}',
             type:'PUT',
             contentType:'application/json', // clien gui len sever
             data : JSON.stringify(data),  // CHUYỂN ĐỔI OPJECT JAVASPRIT SANG JSON
             dataType : 'json',   // TỪ SEVER TRẢ VỀ CHO Client
             success: function (result) {
                 window.location.href = "${NewURL}?type=edit&id="+result.id+"&message=update_success";
             },
             error:function (result) {
                 window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=orror_system";

             }
         });
         }
  });

 </script>
</body>
</html>
