pipeline{
	parameters{
		choice(name: "NodeName", choices: ["master", "slave-win"], description: "どのノードで実行するか")
	}
	agent{
		label "${params.NodeName}"
	}
	stages{
		stage("A"){
			steps{
				echo "hello jenkins of ${params.NodeName}"
				// echo "OS : ${env.os.name}"

				script{
					def jenkins = hudson.model.Hudson.instance
					def slaves = jenkins.slaves
					slaves.each {
						def com = it.toComputer()
						def properties = com.getSystemProperties()
						if( properties != null )
						{
							def ver = properties["os.name"]
							if( ver != null )
							{
							println(it.getNodeName())
							println(ver)
							}
						}
					}
				}
			}
		}
	}
	post{
		always{
			cleanWs notFailBuild: true
		}
	}
}