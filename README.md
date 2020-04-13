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