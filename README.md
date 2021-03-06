# 電卓の作成
## 要件
* 自然数同士の２項による四則計算

## 設計
### MVVMアーキテクチャ

Google公式のMVVMアーキテクチャを参考にしています
* https://github.com/android/architecture-components-samples


## 画面構成
|　　　　　　　画面名　　　　　　　| キャプチャ画像 | 
| :------------------: | :--: |
| 電卓画面 | <img src="https://user-images.githubusercontent.com/28224709/141817145-38312a6d-5f39-4fbf-8b5c-6ff5af63a32f.png" width="30%"> |
| 0除算エラーダイアログ | <img src="https://user-images.githubusercontent.com/28224709/141817661-0b7746a9-c7ee-4a72-8620-866af7783717.png" width="30%"> |
| 2項目未入力エラーダイアログ | <img src="https://user-images.githubusercontent.com/28224709/141818143-0d3065c5-c644-47eb-b9b9-e5d7e4e17c95.png" width="30%"> |
| int(32bit)最大値<br>エラーダイアログ*1 | <img src="https://user-images.githubusercontent.com/28224709/141818359-4f174334-1188-470b-90f4-54dd2d6f4554.png" width="30%"> |

[参考]
1. https://mekou.com/linux-magazine/%E3%81%BE%E3%81%A8%E3%82%81-java-%E6%95%B0%E5%80%A4-%E2%87%94-%E6%96%87%E5%AD%97%E5%88%97%E5%A4%89%E6%8F%9B-%E6%95%B0%E5%80%A4%E6%9C%80%E5%A4%A7%E5%80%A4/

## テスト実行結果
* `ExampleUnitTest`に記載したテストコードの実行結果です。

<img src="https://user-images.githubusercontent.com/28224709/141819152-1da32a7a-a767-4f9a-8eeb-1bd95e502142.png" width="90%">

* `ExampleInstrumentedTest`に記載したUIテストの実行結果です。

<img src="https://user-images.githubusercontent.com/28224709/141825164-a8d99dc3-bad3-470d-9543-b9255ffc2c1c.png" width="90%">

