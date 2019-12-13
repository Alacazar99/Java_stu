# @Time    : 2019/10/2 12:58
# @Author  : 帅气的陈小陌
# @Email   : 13784197113@163.com
# File     : wxpython获取文本内容并显示.py
# Software : PyCharm
import wx
import csv


class MyFrame(wx.Panel):
    def __init__(self, parent):
        wx.Panel.__init__(self, parent)

        self.sizer0 = wx.BoxSizer(wx.HORIZONTAL)
        self.id_name = wx.StaticText(self, label="输入学号/姓名：", pos=(20, 40))
        self.input_id_name = wx.TextCtrl(self, pos=(20, 60), size=(100, -1))
        self.sizer0.Add(self.id_name, 1, wx.EXPAND)
        self.sizer0.Add(self.input_id_name, 2, wx.EXPAND)

        self.sizer1 = wx.BoxSizer(wx.HORIZONTAL)
        self.lblname = wx.StaticText(self, pos=(20, 40))
        self.editname = wx.TextCtrl(self,  pos=(20, 60), size=(300, -1))
        self.sizer1.Add(self.lblname, 1, wx.EXPAND)
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

        # 结合按钮和输入框
        self.sizer = wx.BoxSizer(wx.VERTICAL)
        self.sizer.Add(self.sizer0, 0, wx.EXPAND)
        self.sizer.Add(self.sizer1, 0, wx.EXPAND)
        self.sizer.Add(self.sizer2, 0, wx.EXPAND)

        self.SetSizer(self.sizer)

        self.Bind(wx.EVT_BUTTON, self.OnClick1, self.button1)
        self.Bind(wx.EVT_BUTTON, self.OnClick2, self.button2)
        self.Bind(wx.EVT_BUTTON, self.OnClick3, self.button3)

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







class DataHandle:
    def getIdInformattion(self, ID):
        result = []
        obj_csv = open("信息表.csv", 'r', newline='')
        read_csv = csv.reader(obj_csv)

        for line in read_csv:
            if line[3] == ID:  # 这里我测试文件写的是把学号放在了第三个位置，后续可根据实际情况修改
                result = line
        obj_csv.close()
        return result


if __name__ == "__main__":
    # demo = DataHandle()
    # print(demo.getIdInformattion("20178666"))
    # ['陈小陌', '数学于统计学院', '信科1702', '20178666', '3098']
    app = wx.App(False)
    frame = wx.Frame(None)
    panel = MyFrame(frame)
    frame.Show()
    app.MainLoop()

