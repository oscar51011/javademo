# Annotation (標註)

- JDK5 開始支援
- 可用於編譯時期檢查
- 可用於執行時期讀取組態資訊

##### 1. 內建 annotation ( 出現於 java.lang )
- @Override: 使用在 method上，用來提示覆寫了父類別
- @Deprecated: 使用在 method上，用來提示該方法已經被過時，建議不要再使用
- @SuppressWarnings: 抑制警告訊息 ( 可使用參數 value = { args1, args2 ...etc } 定義抑制警告類型 )<br>
  ex: **unchecked - 執行了未檢查型別轉換 **
- @FunctionalInterface: 協助檢查 interface 是否滿足 lambda 的型態 ( 為 java8 時所新增 )

##### 2. meta-annotation
- @Target: 描述註解使用範圍
```
	1.ElementType.ANNOTATION_TYPE: meta-annotation為此類型，用來修飾註解
	2.ElementType.METHOD: 修飾 method EX: springMVC 的 @GATEMAPPING
	3.ElementType.TYPE: 修飾class, interface, enum, annotation  EX: java8 的 @FunctionalInterface
	4.ElementType.FIELD: 修飾成員變數 EX: java.persistence 的 @Column 
	5.ElementType.PARAMETER: 修飾方法參數 EX: springMVC 的 @PathVariable
	6.ElementType.CONSTRUCTOR: 修飾構造器 EX: spring 的 @Autowired
	7.ElementType.LOCAL_VARIABLE: 修飾區域變數 EX: spring 檢核參數的 @NotNull 可以用在多個場域
	8.ElementType.PACKAGE: 修飾 package
	
	Java 8新增兩個(待補充)
	9.
	10.
	
	Java 9新增一個(待補充)
	11.
	
	Java 16新增一個(待補充)
	12.
```	
	
- @Retention: 描述註解生命週期

	RetentionPolicy.SOURCE:	
		只會出現在程式碼中，編譯後不會出現在class檔中
	RetentionPolicy.CLASS:
		出現在程式碼中，且會編譯進class檔中，但運行期無任何效果
	RetentionPolicy.RUNTIM:
		從程式碼至到運行期間都會存在，可以使用 Reflection 機制取得 annotation 的訊息
- @Documented: 使用 javadoc 命令生成API檔案時，如要要將標注資料加入文檔，才需要加上此註解
- @Inherited: 具有繼承性，代表子類別可以拿到父類別的註解訊息 <br>
  ※ 只有 class-level annotation 可以使用, method-level 則無法

##### 3. 自定義 annotation
- 自定義annotation 需使用 @interface
- 定義屬性時，若名稱為 **value** ，可以省略屬性名稱
- 成員屬性有預設值時，可以使用 **defalut** 關鍵字
- 使用 **反射** 機制 可以取得 annotation 的值
