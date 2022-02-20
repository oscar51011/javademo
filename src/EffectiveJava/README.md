# Effective Java 3rd

藉由學習並實作 Effectice Java third Edition ( joshua Bloch )

- 第52條. 慎用重載(overload)
- 第59條. 了解和使用java standard library ( 常用的 java.lang , java.util , java.io ... etc )
- 第60條. 如果需要精確結果, 避免使用 **float** 和 **double** ( 使用 BigDecimal 也避免使用 new BigDecimal(Double double) 的 constructor )
- 第63條. 了解字串連接效能 ( String 為 immutable )
- 第64條. 使用 interface 宣告 勝過 使用 instance ( 程式可以更加靈活 , 抽換比較不會有負擔 ; 如果沒有對應的介面, 使用必要功能最小的實體類來實作 )
- 第66條. 謹慎使用 Java Native Interface

	1. java隨著版本演進, 效能已有提升, 使用 JNI 來提升效能需要評估是否有必要
	2. Java9 已有提供 Process API, 可以針對 OS 的 process 進行控制 & 管理
- 第67條. 謹慎的進行優化 ( 待研究 )
- 第68條. 命名規則符合普遍接受的習慣

	 1. package/module: 用 . 分隔, 都用小寫表示, 組成最好不超過8個字, 且鼓勵用有意義的縮寫形式
	 2. class/interface: 首字大寫, 盡量不使用縮寫形式
	 3. method/field: 首字小寫
	 4. constant  field: 全字大寫, 多個單字使用 _ 隔開
- 第69條.