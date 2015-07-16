<h3>Select file to upload:</h3>
<form action="uploadingFile?${_csrf.parameterName}=${_csrf.token}" method="POST" enctype="multipart/form-data">
	Select File: <input type="file" name="file" />
	<br/>
	Name: <input type="text" name="name">
	<br/>
	<input type="submit" value="Upload">Click here to upload file!
</form>
<!-- ./upload?${_csrf.parameterName}=${_csrf.token} -->