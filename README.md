# AP

## 简介

AP (Advanced Programming 的缩写) 是BuptAAA 的 Job Seeking Package 底下的实验性项目。目标是帮助北邮学子强化编程技能，顺利拿到如意的offers，并把这过程的资料和经验积累沉淀下来。

## 目标

以尽量少的资源达到最好的效果

## 工作安排（暂定）

1. 每周五发放15道题（每道题都需要编程）

   1.1 题目的详尽描述放在[prob](https://github.com/BUPT-AC/AP/tree/master/workplace/prob)的每周文件夹里
   
   1.2 每周计划放在[plan](https://github.com/BUPT-AC/AP/tree/master/plan)对应的周文件

2. 写代码过程要写testcases

3. 从这15道题为每人选出这周要写report的题目, 一道题写成一份```英文```report

4. 每人会被分配三个review对象（成员），要对他/她的代码和报告进行review

5. 每周开会总结

## 时间安排

1. 周二: 上周代码提交ddl（EST 11:59 p.m.）
2. 周三: review和report的ddl（EST 11:59 p.m.）
3. 周四: 开会时间
4. 周五: 题目和report题目发放时间

## 任务提交方式

1. 代码

   1.1 push到[src](https://github.com/BUPT-AC/AP/tree/master/workplace/src)， 每人需在src底下自建一个目录，如src/cchen
   
   1.2 代码的命名和[prob](https://github.com/BUPT-AC/AP/tree/master/workplace/prob)里对应的题目命名一致，如[MergeRingStones.md](https://github.com/BUPT-AC/AP/blob/master/workplace/prob/20150618/MergeRingStones.md),对应的文件名可以为MergeRingStones.py , MergeRingStones.java, ...

2. Testcase

   2.1 push到[testcase](https://github.com/BUPT-AC/AP/tree/master/workplace/testcase)
   
   2.2 testcase的命名和[prob](https://github.com/BUPT-AC/AP/tree/master/workplace/prob)里对应的题目命名一致，如[MergeRingStones.md], 则可以有MergeRingStones001.in , MergeRingStones002.in, ...
   
   2.3 要注意[testcase 目录下](https://github.com/BUPT-AC/AP/tree/master/workplace/testcase)不同题目对应的testcase的最大序号, 如MergeRingStones最大的序号是010 (也就是MergeRingStones011.in), 则push的下一个相应的testcase是是MergeRingStones012.in

3. Review

   直接对[src](https://github.com/BUPT-AC/AP/tree/master/workplace/src)里想对应的代码进行comment
   
4. Report

   4.1 push 到 [report](https://github.com/BUPT-AC/AP/tree/master/workplace/report)
   
   4.2 暂时统一为md格式（markdown文件）
   
   4.3 对每道题单独写report, 命名方式和代码和testcase的方式类似
   
## 使用说明

这部份主要对这个repo的不同分块进行简单说明

### workplace

最重要的地方，是我们实际刷题的地方， 里面分成四个部分

1. src: 代码提交的地方。每个人需要在src底下自建一个目录，如src/cchen

2. report: 报告提交的地方。每个人需要在report底下自建一个目录，如report/cchen 。 另外，里面有个template，会存放写报告的模板，以供参考。

3.  prob: 每周都会放新的题目进去，每个题目文件都有具体的description

4.  testcase：与每周题目想对应的testcase，这个需要思考testcases，以txt文本方式写进去

### summary

这暂时有两个地方

1. err：是存放错误，尤其常放的错误的地方
2. gen: generalization 的缩写，是存放常用可推广的方法总结的地方

### idea

这部分主要存放各个成员对这个项目的建设的宝贵意见。意见会按优先等级取出来作为每个阶段实际操作的指导。

### plan

暂时有两类型的文件：

1. ToDo.md : 会把近期阶段还没解决的问题放上去。每解决一条，对应的项就会被删除。

2. 20150619.md : 这是个例子，以时间命名。主要记录这周五到下周四的任务，方便成员观看。

### res

这是放resource的地方。它底下有个problib是我们的题库。其他可以放一下资料，如cc150

## 讨论区

通过Github的Issue进行问题讨论

## 奖惩机制（待定）

这部分需大家共同讨论，再确定。

1.	奖励: 尤其需要提供比较有价值，有激励大家的奖励。奖励是通过做额外的任务来实现

2.	惩罚：

    2.1 可以采取梯级措施
    
    2.2 跟不上上ddl的话可能需要做额外的工作，譬如对于本人没有完成的题，要求对其他组员的答案写分析总结，和report一样，放在博客。好处在于在减掉一些summary的工作同时，还可以帮助该成员跟上进度


  

