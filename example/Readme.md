# W03

## Task 1: example 代码工作原理

首先是使用自定义的 class loader 加载 BubbleSorter 类，具体过程如下：

1.  我们自定义的class loader 从 url 上读取 BufferedImage 对象
2. 用 encoder 来 decode 上一步得到的 BufferedImage 对象中编码的信息，得到待加载的类（也就是 Bubble Sorter 类）的 .class 文件的字节码。
3. 调用 defineClass 创建出 Class 对象。

得到了 Bubble Sorter 的 . class 对象之后就可以使用它的 .newInstance() 方法创建 Bubble Sorter 的实例。

在上述部分中第 2 步 decode 的原理如下：

使用从 url 读取的 BufferedImage 对象的 getRGB 方法可以得到图片的 ARGB pixel 数组，其中每个 ARGB pixel 是一个 int 值，第一个字节（最高有效字节）是alpha 值，表示透明度，后三个字节是 RGB 值，每种颜色用一个字节表示。当 RGB 值相差很小时，颜色差别很小，因此可以使用后三个字节的每个字节的最低两位来存储别的信息，而又对图片的外观影响很小，以达到隐写的目的,example 中的代码中的 url 上的图片就是使用这种方法存储了 Bubble Sorter 类的字节码。decode 方法读取每个 pixel 的后三个字节的最低两位，以byte 为单元存储得到的二进制位串在一个 byte 数组里。但是最后还要丢弃 0xCAFEBABE 之前的字节，因为 .class 文件总是以 magic value 开始，其值为 0xCAFEBABE. 

## Task 2：

![example.InsertionSorter](https://i.loli.net/2021/09/27/7GiMhHFCoBj23dW.png)

https://i.loli.net/2021/09/27/7GiMhHFCoBj23dW.png



![example.QuickSorter](https://i.loli.net/2021/09/26/M7xmdaBNXr8gVKo.png)

https://i.loli.net/2021/09/26/M7xmdaBNXr8gVKo.png

## Task3:

可视化链接： https://asciinema.org/a/438281 插排版本

可视化链接：https://asciinema.org/a/438283 快排版本

## Task 4:

