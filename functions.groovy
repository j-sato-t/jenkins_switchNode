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
		bat "cd"
	}
}

void LoopCheck()
{
	def array = []

	for(i in 0..10)
	{
		array.push(i)
	}

	String nums = ""
	array.each
	{
		nums += it
	}
	echo nums
}

return this