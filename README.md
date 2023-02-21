# spring-boot-kafka-practice

{%hackmd Hy_uVFcRD %}
# spring-boot-kafka-practice

## 專案位置
https://github.com/mister33221/spring-boot-kafka-practice.git

## 環境
* java17
* spring boot 3.0.2
* maven

## 主要想要測試的項目
1. 不同port中，同一個group的consumer會如何消費?如果其中一個掛掉了會怎麼樣?
2. consumer group在消息分配的機制?
3. 如果消費途中其中有一個broker壞掉了，kafka會如何反應?

## 介紹

* 本專案分為四個部分
    * docker-compose.yml
        * 輸入以下指令啟動kafka
            ```
            docker-compose up
            ```
        * 輸入以下指令移除kafka
            ```
            docker-compose down
            ```
        * 此yml中包含啟動了zookeeper以及三個broker
    * service1
        * port為8080
        * controller1
            內含各類api接口，可依照不同情境自行修改並測試。
            * sendMessage: If you did't set the key or partition, the message will be sent to the random partition
            * sendMessageWithKey: If you set the key, the message will be sent to the same partition
            * sendMessageWithPartition: If you set the partition, the message will be sent to the same partition
            * sendMessageWithKeyAndPartition: If you set the key and partition, the message will be sent to the same partition
        * Producer1
            * 實作上述各類接口
        * Consumer1
            * 印出topic、partition、offset、key、value
    * service2
        * port為8081
        * Consumer2
            * 印出topic、partition、offset、key、value
    * prettyZoo
        * 這是一個方便用來觀測zooKeeper中資料的軟體，使用非常簡單
            1. 啟動prettyZoo.exe
            2. 點選左上的+號，輸入zooKeeper的port號並save
                ![](https://i.imgur.com/o6s51k6.png)
            3. 點擊connect
                ![](https://i.imgur.com/vhUSZOZ.png)
            4. 如果成功的話就會是以下畫面
                ![](https://i.imgur.com/RKd8cx3.png)

