# @Time    : 2019/10/5 15:13
# @Author  : 帅气的陈小陌
# @Email   : 13784197113@163.com
# File     : 文件导入-单个信息综合.py
# Software : PyCharm
import wx
import os
import csv


class MainWindow(wx.Frame):
    def __init__(self, parent, title):
        self.dirname = ''

        # 当尺寸id传参是"-1"的时候代表使用默认值。
        # 在这个例子中，我们使用宽度是200px，长度为默认
        wx.Frame.__init__(self, parent, title=title)

        # 菜单栏
        filemenu = wx.Menu()
        menuOpen = filemenu.Append(wx.ID_OPEN, "&Open", " Open a file to edit")  # 第三个参数是显示在状态栏上
        menuAbout = filemenu.Append(wx.ID_ABOUT, "&About", " Information about this program")
        menuExit = filemenu.Append(wx.ID_EXIT, "E&xit", " Terminate the program")

        # Creating the menubar（菜单栏）.
        menuBar = wx.MenuBar()
        menuBar.Append(filemenu, "&File")  # Adding the "filemenu" to the MenuBar
        self.SetMenuBar(menuBar)  # Adding the MenuBar to the Frame content.把菜单栏添加到框架上

        # Events.
        self.Bind(wx.EVT_MENU, self.OnOpen, menuOpen)
        self.Bind(wx.EVT_MENU, self.OnExit, menuExit)
        self.Bind(wx.EVT_MENU, self.OnAbout, menuAbout)

        # 创建按钮，并绑定事件
        self.bt_confirm = wx.Button(self, label='写入')
        self.Bind(wx.EVT_BUTTON, self.OnClickWrite, self.bt_confirm)

        # 创建文本和输入框
        self.title = wx.StaticText(self, label="请输入相关信息")
        self.label_info1 = wx.StaticText(self, label='信息1：')
        self.text_info1 = wx.TextCtrl(self, style=wx.TE_LEFT)
        self.label_info2 = wx.StaticText(self, label='信息2：')
        self.text_info2 = wx.TextCtrl(self, style=wx.TE_LEFT)
        self.label_info3 = wx.StaticText(self, label='信息3：')
        self.text_info3 = wx.TextCtrl(self, style=wx.TE_LEFT)
        self.label_info4 = wx.StaticText(self, label='信息4：')
        self.text_info4 = wx.TextCtrl(self, style=wx.TE_LEFT)
        self.label_info5 = wx.StaticText(self, label='信息5：')
        self.text_info5 = wx.TextCtrl(self, style=wx.TE_LEFT)

        # 添加容器，容器中控件按横向并排排列
        hsizer_info1 = wx.BoxSizer(wx.HORIZONTAL)
        hsizer_info1.Add(self.label_info1, proportion=0, flag=wx.ALL, border=5)
        hsizer_info1.Add(self.text_info1, proportion=1, flag=wx.ALL, border=5)
        hsizer_info2 = wx.BoxSizer(wx.HORIZONTAL)
        hsizer_info2.Add(self.label_info2, proportion=0, flag=wx.ALL, border=5)
        hsizer_info2.Add(self.text_info2, proportion=1, flag=wx.ALL, border=5)
        hsizer_info3 = wx.BoxSizer(wx.HORIZONTAL)
        hsizer_info3.Add(self.label_info3, proportion=0, flag=wx.ALL, border=5)
        hsizer_info3.Add(self.text_info3, proportion=1, flag=wx.ALL, border=5)
        hsizer_info4 = wx.BoxSizer(wx.HORIZONTAL)
        hsizer_info4.Add(self.label_info4, proportion=0, flag=wx.ALL, border=5)
        hsizer_info4.Add(self.text_info4, proportion=1, flag=wx.ALL, border=5)
        hsizer_info5 = wx.BoxSizer(wx.HORIZONTAL)
        hsizer_info5.Add(self.label_info5, proportion=0, flag=wx.ALL, border=5)
        hsizer_info5.Add(self.text_info5, proportion=1, flag=wx.ALL, border=5)

        hsizer_button = wx.BoxSizer(wx.HORIZONTAL)
        hsizer_button.Add(self.bt_confirm, proportion=0, flag=wx.ALIGN_CENTER, border=5)

        # 添加容器，容器中空间按纵向并排排列
        self.vsizer_all = wx.BoxSizer(wx.VERTICAL)
        self.vsizer_all.Add(self.title, proportion=0, flag=wx.BOTTOM | wx.TOP | wx.ALIGN_CENTER, border=15)
        self.vsizer_all.Add(hsizer_info1, proportion=0, flag=wx.EXPAND | wx.LEFT | wx.RIGHT, border=45)
        self.vsizer_all.Add(hsizer_info2, proportion=0, flag=wx.EXPAND | wx.LEFT | wx.RIGHT, border=45)
        self.vsizer_all.Add(hsizer_info3, proportion=0, flag=wx.EXPAND | wx.LEFT | wx.RIGHT, border=45)
        self.vsizer_all.Add(hsizer_info4, proportion=0, flag=wx.EXPAND | wx.LEFT | wx.RIGHT, border=45)
        self.vsizer_all.Add(hsizer_info5, proportion=0, flag=wx.EXPAND | wx.LEFT | wx.RIGHT, border=45)
        self.vsizer_all.Add(hsizer_button, proportion=0, flag=wx.ALIGN_CENTER | wx.TOP, border=15)

        self.sizer0 = wx.BoxSizer(wx.HORIZONTAL)
        self.id_name = wx.StaticText(self, label="输入学号/姓名：")
        self.input_id_name = wx.TextCtrl(self, size=(100, -1))
        self.sizer0.Add(self.id_name, 1, wx.EXPAND)
        self.sizer0.Add(self.input_id_name, 2, wx.EXPAND)

        self.sizer1 = wx.BoxSizer(wx.HORIZONTAL)
        self.lblname = wx.StaticText(self, label="学号：", size=(100, -1))
        self.editname = wx.TextCtrl(self, size=(300, -1))
        self.sizer1.Add(self.lblname, 0, wx.EXPAND)
        self.sizer1.Add(self.editname, 1, wx.EXPAND)

        # 这样能做到显示信息，但为已选中状态，以后得改

        # 按钮
        self.sizer2 = wx.BoxSizer(wx.HORIZONTAL)
        self.button1 = wx.Button(self, -1, '查询')
        self.button2 = wx.Button(self, -1, '修改')
        self.button3 = wx.Button(self, -1, '删除')
        self.sizer2.Add(self.button1, 1, wx.EXPAND)
        self.sizer2.Add(self.button2, 1, wx.EXPAND)
        self.sizer2.Add(self.button3, 1, wx.EXPAND)
        self.Bind(wx.EVT_BUTTON, self.OnClick1, self.button1)
        self.Bind(wx.EVT_BUTTON, self.OnClick2, self.button2)
        self.Bind(wx.EVT_BUTTON, self.OnClick3, self.button3)


        # Use some sizers to see layout options
        self.sizer = wx.BoxSizer(wx.VERTICAL)
        self.sizer.Add(self.vsizer_all, 0, wx.EXPAND)
        self.sizer.Add(self.sizer0, 0, wx.EXPAND)
        self.sizer.Add(self.sizer1, 0, wx.EXPAND)
        self.sizer.Add(self.sizer2, 0, wx.EXPAND)

        # Layout sizers
        self.SetSizer(self.sizer)
        self.SetAutoLayout(1)
        self.sizer.Fit(self)
        self.Show()

    def OnAbout(self, event):
        # Create a message dialog box
        dlg = wx.MessageDialog(self, " A sample editor \n in wxPython", "About Sample Editor", wx.OK)
        dlg.ShowModal()  # Shows it
        dlg.Destroy()  # finally destroy it when finished.

    def OnExit(self, event):
        self.Close(True)  # Close the frame.

    def OnOpen(self, event):
        self.dirname = ''
        dlg = wx.FileDialog(self, "Choose a file", self.dirname, '', '*.*', wx.FD_OPEN)
        if dlg.ShowModal() == wx.ID_OK:
            self.filename = dlg.GetFilename()
            self.dirname = dlg.GetDirectory()
            fileUrl = os.path.join(self.dirname, self.filename)
            file = open("信息表.csv", 'a', newline='')
            obj_csv = open(fileUrl, 'r', newline='')
            read_csv = csv.reader(obj_csv)
            for line in read_csv:
                csv.writer(file).writerow(line)
            file.close()
            obj_csv.close()
            wx.MessageBox("导入文件成功！")
        else:
            wx.MessageBox("用户取消了导入文件！")
        dlg.Destroy()

    def OnClick1(self, event):    # 查询按钮
        input_value = self.input_id_name.GetValue()
        result = []
        obj_csv = open("信息表.csv", 'r', newline='')
        read_csv = csv.reader(obj_csv)
        if input == '':
            wx.MessageBox("请输入学号或姓名后查询！")
            return 0
        try:
            ID = int(input_value)  # 如果不抛出异常，代表输入的是学号
            for line in read_csv:
                if line[3] == str(ID):  # 这里我测试文件写的是把学号放在了第三个位置，后续可根据实际情况修改
                    result = line
            if result == []:
                wx.MessageBox("输入学号不存在，请核对后输入！")
                return 0
        except:
            # 上面抛出异常了，代表输入的是姓名
            for line in read_csv:
                if line[0] == input_value:  # 这里我测试文件写的是把学号放在了第零个位置，后续可根据实际情况修改
                    result = line
            if result == []:
                wx.MessageBox("输入姓名不存在，请核对后输入！")
                return 0

        obj_csv.close()
        out = '|'.join(result)
        self.lblname.SetLabel("学号"+result[3]+":")
        self.editname.SetValue(out)
        return 0

    def OnClick2(self, event):   # 修改按钮
        getInfo = self.editname.GetValue()
        getID = self.lblname.GetLabel()[2:-1]   # 用户可能把所有信息均修改，之前的id起到定位作用
        if getInfo == '':
            wx.MessageBox("显示信息为空，请首先进行查询，方可修改！")
            return 0
        listInfo = getInfo.split("|")

        obj_csv = open("信息表.csv", 'r', newline='')
        read_csv = csv.reader(obj_csv)
        newWriterLines = []

        for line in read_csv:
            if line[3] == getID:
                newWriterLines.append(listInfo)
            else:
                newWriterLines.append(line)
        obj_csv.close()
        newFile = open("信息表.csv", 'w', newline='')  # 重新写入，覆盖原文件
        for line in newWriterLines:
            csv.writer(newFile).writerow(line)
        newFile.close()
        wx.MessageBox("修改成功，可再次查询验证！")
        self.lblname.SetLabel("")   # 修改和删除后均把表单清空
        self.editname.SetValue("")
        return 0

    def OnClick3(self, event):   # 删除按钮
        getID = self.lblname.GetLabel()[2:-1]  # 用户可能把所有信息均修改，之前的id起到定位作用
        getInfo = self.editname.GetValue().split("|")

        dlg = wx.MessageDialog(None, u"确认删除？", u"warning", wx.YES_NO | wx.ICON_QUESTION)
        if dlg.ShowModal() == wx.ID_YES:
            obj_csv = open("信息表.csv", 'r', newline='')
            read_csv = csv.reader(obj_csv)
            newWriterLines = []

            for line in read_csv:
                if line[3] != getID:
                    newWriterLines.append(line)
            obj_csv.close()
            newFile = open("信息表.csv", 'w', newline='')  # 重新写入，覆盖原文件
            for line in newWriterLines:
                csv.writer(newFile).writerow(line)
            newFile.close()
            wx.MessageBox("同学{}信息已删除！".format(getInfo[0]))
        else:
            wx.MessageBox("取消删除！")
        dlg.Destroy()

        self.lblname.SetLabel("")
        self.editname.SetValue("")
        return 0

    def OnClickWrite(self, event):
        # 点击确定按钮执行方法
        message = ''
        info1 = self.text_info1.GetValue()   # 获取输入，类型为字符串
        info2 = self.text_info2.GetValue()
        info3 = self.text_info3.GetValue()
        info4 = self.text_info4.GetValue()
        info5 = self.text_info5.GetValue()
        inputStr = [info1, info2, info3, info4, info5]
        file = open("信息表.csv", 'a', newline='')
        csv.writer(file).writerow(inputStr)
        file.close()
        wx.MessageBox("写入成功！")


if __name__ == "__main__":
    app = wx.App(False)
    frame = MainWindow(None, "Sample editor")
    app.MainLoop()

