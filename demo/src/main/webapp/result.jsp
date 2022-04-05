<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>结果</title>
</head>
<body>


  


<form action="download"  method="post">
        <input type="text" id="filename" name="filename" type="text" value="${downloadfile}" readonly/><br/>
        <input type="submit" value="下载XML" />
</form>
 
 <p>  信息提示:</p>
${message}
</br>

 <p >Excel内容:</p>
 <table class="table table-hover">

    <thead>
      <tr>
        <th><b>序列</b></th>
        <th><b>发票代码 </b></th>
        <th><b>发票号码</b></th>
        <th><b>销方识别号</b></th>
        <th><b>销方名称</b></th>
        <th><b>购方识别号 </b></th>      
        <th><b>购方名称</b></th>
        <th><b>购方地址电话</b></th>
        <th><b>购方银行账号</b></th>
        <th><b>密文</b></th>
        <th><b>开票日期</b></th>
        <th><b>金额</b></th>
        <th><b>税额</b></th>
        <th><b>主要商品名称</b></th>
        <th><b>备注</b></th>
        <th><b>是否作废</b></th>
         <th><b>发票类别</b></th>
         <th><b>是否收购</b></th>
         <th><b>是否差额征收</b></th>
         <th><b>开票机号</b></th>
         <th><b>商品名称</b></th>
         <th><b>发票类别</b></th>
         <th><b>商品税收分类编码</b></th>
         <th><b>数量</b></th>
         <th><b>金额</b></th>
         <th><b>税额</b></th>
         <th><b>税率</b></th>
          <th><b>规格型号</b></th>
      </tr>
    </thead>
    <tbody>
   
      <c:forEach  var="excel" items="${excecontentslist}"  varStatus="status">
      <tr>
         
      
      <td><c:out value="${status.index + 1}"></c:out></td>
        <td><c:out value="${excel.invoicecode}"></c:out></td>
        <td><c:out value="${excel.invoicenum}"></c:out></td>
        <td><c:out value="${excel.sellerid}"></c:out></td>
        <td><c:out value="${excel.sellername}"></c:out></td>
        <td><c:out value="${excel.buyerid}"></c:out></td>
        <td><c:out value="${excel.buyername}"></c:out></td>
        <td><c:out value="${excel.buyeradd}"></c:out></td>
        <td><c:out value="${excel.buyerbankacc}"></c:out></td>
        <td><c:out value="${excel.cryptocontents}"></c:out></td>
        <td><c:out value="${excel.issuedate}"></c:out></td>
        <td><c:out value="${excel.total}"></c:out></td>
        <td><c:out value="${excel.taxtotal}"></c:out></td>
        <td><c:out value="${excel.mainproductname}"></c:out></td>
        <td><c:out value="${excel.memo}"></c:out></td>
        <td><c:out value="${excel.ifappeal}"></c:out></td>
        <td><c:out value="${excel.invoicetype}"></c:out></td>
        <td><c:out value="${excel.ifaccquired}"></c:out></td>
        <td><c:out value="${excel.ifdiffecent}"></c:out></td>
        <td><c:out value="${excel.poscode}"></c:out></td>
        <td><c:out value="${excel.productname}"></c:out></td>
        <td><c:out value="${excel.taxtypecode}"></c:out></td>
        <td><c:out value="${excel.thenumber}"></c:out></td>
        <td><c:out value="${excel.amount}"></c:out></td>
        <td><c:out value="${excel.tax}"></c:out></td>
        <td><c:out value="${excel.taxrate}"></c:out></td>
        <td><c:out value="${excel.prodsize}"></c:out></td> 
      </tr>
   </c:forEach>
    </tbody> 
  </table>
 
</body>
</html>