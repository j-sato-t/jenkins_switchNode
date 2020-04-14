pipeline{
	parameters{
		choice(name: "NodeName", choices: ["master", "slave-win"], description: "どのノードで実行するか")
	}
	agent{
		label "${params.NodeName}"
	}
	stages{
		stage("load script"){
			steps{
				script{
					def functions = load "functions.groovy"
				}
			}
		}
		stage("Check node"){
			steps{
				echo "hello jenkins of ${params.NodeName}"
				echo "Node : ${env.NODE_NAME}"
				echo "IsUnix : ${isUnix()}"
			}
		}
		stage("branch action"){
			steps{
				script{
					if(isUnix()){
						echo "node is unix like"
					}else{
						echo "node is not unix like"
					}
				}
			}
		}
		stage("check function"){
			steps{
				script{
					functions.CheckIsUnix()
				}
			}
		}
		stage("pwd"){
			steps{
				script{
					functions.ExecutePwd()
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