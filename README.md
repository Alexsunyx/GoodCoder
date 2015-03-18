# GoodCoder
百度GoodCoder认证工程代码

在我们的开发任务中，最常见的一项工作就是解析并读取各种词表文件，请设计并实现一个通用的词表解析读取工具类(一个或者几个class/struct组成)，
解析并读取如下形式的词表：

   <col1>\t<col2>\t...\t<coln>

每一行都是一条记录，每一列可能的类型包括：

   * int
   * float
   * char *
   * 形如num:item1,item2,item3的数组（可以理解为T[num]的数组，T是用户给出某种build-in类型）
   * 其他用户自定义类型

每一列的数据中均不包含\t字符，每一行以\n结尾。

要求：

    1. 对于非用户自定义类型，封装解析行为；用户自定义类型，调用用户给出的parse函数（从string翻译成用户struct)完成
    2. 用户能通过某些形式，定制这个词表的结构，指明每一列的类型是什么
    3. 用户能逐行读取这个词表的信息，即按序读取每一行，然后能解析出这一行中的每一列内容
    4. 容错采用出错则报警并跳过整行记录的方式，但不论输入任何错误数据，程序不能出core
    5. API设计友好，做到自解释
    6. 代码严格遵守Inf编码规范
    7. 代码的可读性和可维护性好
    8. 完成相应的单元测试, 你的代码必须可编译， 单元测试有效而且通过;
