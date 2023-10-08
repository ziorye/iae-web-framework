<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>File Upload by SpringMVC</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form method="POST" action="fileUploadController" enctype="multipart/form-data" >
  File:
  <input type="file" name="avatar" required /> <br/>
  Description:
  <input type="text" name="description" required />
  <br/>
  <input type="submit" value="Upload" name="upload" id="upload" />
</form>
</body>
</html>
