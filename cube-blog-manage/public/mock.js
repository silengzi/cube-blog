export const mockData = [
    {
        "title": "fixed位置偏移的问题", // 标题
        "summary": "关于fixed位置偏移的问题做出探讨",   // 摘要
        "create_time": "2024-01-09",    // 发布日期
        "state": "1",   // 0: 删除  1: 发布   2: 草稿
        "article": `
            元素的位置相对于浏览器窗口是固定位置，即使窗口是滚动的它也不会移动。

            以上说的是正常情况。
            
            还有一种特殊情况就是，当使用了\`fixed\`定位的元素的父元素使用了\`transform\`时，那么（猜测）\`fixed\`就会变成\`absolute\`定位，效果确实是这样的。
            
            以下代码以供检验：
            
            \`\`\` html
            <!DOCTYPE html>
            <html lang="en">
            <head>
            <meta charset="UTF-8">
            <title>fixed 位置偏移的问题</title>
            <style>
                * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                }
                .father {
                width: 100vw;
                height: 100vh;
                background-color: red;
                /* 父元素使用 transform ，把下面这行注释掉 fixed 就没问题了 */
                transform: translate(25%, 25%);
                /* margin: 25% 0 0 25%; */  /* 使用 margin 改变父元素的位置则不会影响 fixed 定位的效果 */
                }
                .child {
                width: 50vw;
                height: 50vh;
                background-color: green;
                position: fixed;
                left: 25%;
                top: 25%;
                }
            </style>
            </head>
            <body>
            <div class="father">
                <div class="child"></div>
            </div>
            </body>
            </html>
            \`\`\`
        ` // 文章内容
    },
    {
        "title": "批量修改文件后缀名/扩展名", // 标题
        "summary": "批量修改文件后缀名/扩展名",   // 摘要
        "create_time": "2024-01-09",    // 发布日期
        "state": "2",   // 0: 删除  1: 发布   2: 草稿
        "article": `
            1)&nbsp;&nbsp;将需要修改后缀名的文件放到同一个目录下。

            2)&nbsp;&nbsp;在上述目录中新建一个文本文件，在该文本文件中输入如下代码：
            
            \`\`\`txt
            ren *.png *.jpg
            \`\`\`
            
            ren: 重命名操作的指令
            
            *.png：需要修改的文件类型(该示例展示的是将某一类文件转换为另一类文件，全部文件都需要转换的看最后)
            
            *.jpg：修改之后的文件类型
            
            3)&nbsp;&nbsp;写好之后保存该文本文件，之后将该文本文件的后缀名(.txt)，修改为(.bat)
            
            4)&nbsp;&nbsp;双击运行刚刚的.bat文件，批量修改就完成了。
            
            <br /><br />
            
            如果需要将全部文件转换为某一类型的文件，应该这么设置：
            
            \`\`\`txt
            ren *.* *.jpg
            \`\`\`
            
            这样就会把当前目录下的全部文件修改为.jpg类型。
        ` // 文章内容
    }
]