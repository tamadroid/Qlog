- [English](README.md) 
# Qlog
AndroidのLogを簡単にするライブラリです。
ほとんど設定なしに、簡単に多様な出力することができます。

## Setup
`implementation 'jp.tama:qlog:0.2.2'`

## 使用方法
### 事前準備
最初に起動するActivityや、Applicationの「onCreate」で、以下を実施してください。
`Qlog.set(BuildConfig.DEBUG)`

#### 細かく制御したい場合
##### ログを出力(いつでも再開可能です)
`Qlog.set(true)`
##### ログを停止(いつでも停止可能です)
`Qlog.set(false)`

### 実際の使用方法
`Qlog.d("test")`  
※Qlog.dのdには、e、w、i、d、vが使用可能

### 実行結果
`D/(MainActivity.kt:24)[TH:UI][onCreate]: test`
- MainActivity.kt:24  
MainActivity.ktファイルの24行目で実行
- [TH:UI]  
実行スレッドがUI(UI:UI thread、Work:Worker thread)
- [onCreate]  
実行メソッド名(coroutinesなどで取得できない場合は、非表示)
- test  
表示したい文字列。変数なども可能(Any型なので、特に型は気にせず登録可能。
 
## License
This software is released under the MIT License, see LICENSE.
