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
				echo "hello jenkins"
			}
		}
	}
	post{
		always{
			cleanWs notFailBuild: true
		}
		success{
			
		}
		failure{
			
		}
	}
}