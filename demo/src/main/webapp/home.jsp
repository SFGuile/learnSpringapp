<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 
<meta charset="UTF-8">
<title>增值税发票Excel转换为XML程序（测试版）</title>
</head>
<body>

<table style="width:100%">
<tbody>
<tr>
<td><h1 style="text-align: left;">增值税发票Excel转换为XML程序</h1></td>
<td> <p style="font-size:12px;text-align: right;">版本号：20200829</p>
         <p style="font-size:12px;text-align: right;"><a href="../releasenote">修改内容>></a></p></td>
</tr>

</tbody>
</table>
  
 
  <hr/>
  <h4>上传Excel文件:</h4>
  <form method="POST" action="uploadfile"  enctype="multipart/form-data">
    <input type="file" name="file"  accept=".xls"/> <br/><br/>
    <p>填写补充资料：</p>
     <label for="fname">销方地址:</label> 
     <input type="text" id="address" name="address" size="50">
     <label for="lname">销方银行帐号:</label> 
     <input type="text" id="bankaccount" name="bankaccount" size="50"><br/><br/>
     <label for="lname">开票人:</label> 
     <input type="text" id="kpr" name="kpr" size="10"> 
      <label for="lname">收款人:</label> 
     <input type="text" id="skr" name="skr" size="10"> 
      <label for="lname">复核人:</label> 
     <input type="text" id="fhr" name="fhr" size="10"><br/><br/>
    <button type="submit">提交</button>
  </form>
  <hr/>
  <div> 
    ${message} 
  </div>
    
   <div>
   
  </div>
  
  
  

  
</body>
</html>
注意：上传的文件限制最大为100M</br>
由于单位字段Excel是没有些数据的，只能固定用 盒
