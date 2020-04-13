boolean CheckIsUnix()
{
	boolean is_unix = isUnix();
	if(is_unix)
	{
		echo "is unix like"
	}
	else
	{
		echo "is not unix like"
	}

	return is_unix
}

void ExecutePwd()
{
	if(isUnix())
	{
		sh "pwd"
	}
	else
	{
		powershell "pwd"
	}
}

return this