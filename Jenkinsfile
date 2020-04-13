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
				echo "Node : ${env.NODE_NAME}"
			}
		}
	}
	post{
		always{
			cleanWs notFailBuild: true
		}
	}
}