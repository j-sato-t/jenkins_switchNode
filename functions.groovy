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

return this