pipeline{
	parameters{
		choice(name: "NodeName", choices: ["master", "slave-win"], description: "どのノードで実行するか")
	}
	agent{
		label "${params.NodeName}"
	}
	stages{
		stage("Check node"){
			steps{
				echo "hello jenkins of ${params.NodeName}"
				echo "Node : ${env.NODE_NAME}"
				echo "IsUnix : ${isUnix()}"
			}
		}
	}
	post{
		always{
			cleanWs notFailBuild: true
		}
	}
}