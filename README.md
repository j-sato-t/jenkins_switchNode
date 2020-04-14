jenkins_switchNode

## 目的

- master以外のノードで実行する練習
- 環境変数によって処理を切り替える練習（OSの違いに合わせて`bat`と`sh`を切り替える的な）

## 想定段階

1. `choice`パラメータで実行ノードを選べるようにする
1. jenkinsの`echo`を使ってOSの判別に使う環境変数を表示する
	- それぞれのノードで違う結果になることを確認する
		- master : linux
		- slave : windows
1. pipeline直書きでOSごとの処理を作成する
	- `if`の習得を含む
1. 別ファイル関数でOSごとの処理を作成する

## 条件分岐

- `if`を使う
	- `script`に入れる必要がある
```groovy
	stage("stage"){
		steps{
			script{
				if(条件){
					// true時の処理
				}else{
					// false時の処理
				}
			}
		}
	}
```
- ネストが深くなるので関数にまとめたほうがいい？
	- 外部ファイル関係もscript内なので、あまり変わらない？
	- `if-else`がまとまれば見やすくはなる
```groovy
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
					def functions = load "functions.groovy"
					functions.CheckIsUnix()
				}
			}
		}
```
## メモ

- 各ノードでVCSのクライアントが必要（当然だが）
	- GitKrakenだけ使っていてgitのCLIが入っていなかったのでpullができずにエラーになっていた
	- ノード起動中にインストールした際は再接続が必要
- 使用できる環境変数は`http://localhost:8080/env-vars.html/`で確認する
	- ホスト名とポートは実際のものにする
	- 取得時は`env.VALUE_NAME`
- ステージ間で変数を使い回すときは`def`を付けない？