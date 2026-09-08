#!/bin/bash
# 毎朝launchd経由で実行され、通知を出してターミナルでリポジトリを開くだけのスクリプト。
# 記事の作成・commit・pushは対話(Claude Codeセッション)で人間が行う。

REPO_DIR="/Users/ikebatakensuke/Study/java-study"

osascript -e 'display notification "昨日学んだJavaの内容を1つ、振り返りメモに書きましょう" with title "Java振り返り" sound name "Glass"'

osascript -e "tell application \"Terminal\"
    activate
    do script \"cd '$REPO_DIR' && claude\"
end tell"
