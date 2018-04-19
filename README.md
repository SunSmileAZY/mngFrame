# mngFrame
springmvc+mybatis-plus，单表的增删改查，无需编写SQL</br>
引入Vue.js编写了简单的小使用，熟悉MVVM模式。</br>

此项目主要是用于我个人学习框架搭建，一些中间件、java周边技术的基本使用；</br>
如：activeMQ、redis、elasticsearch、shiro、spring AOP的使用、log4J中的MDC、NDC等的使用。</br>

个人认为值得学习的点有：</br>
1、中间件的许多简单demo都可以找到在test包下</br>
2、activeMQ+log4j+spring 日志记录的使用，通过log4j推送日志到MQ，然后接受MQ推送的日志入库。</br>
3、elasticsearch增删改查应用</br>
4、redis整合spring以及基本工具类</br>
5、shiro的基本搭建配置</br>
6、利用AOP切service层打印方法入参返参日志（可减少开发人员日志工作量）。</br>
7、利用log4j的MDC打印操作用户。也可打印操作用户的IP等系统中可能用到的信息。</br>
8、系统中整合了mybatis-plus，单表增删改查无需编写sql，另外编写了一些base类，如表中的创建时间、创建人、修改时间、修改人，这些信息以在base类中进行维护，无需开发人员再去关心。</br>

缺点：</br>
1、内容整合的可能还不够完善，因为这个也是我第一次进行全面性的中间件整合。</br>
2、工具类考虑的可能不够全面。</br>
3、没有按照微服务形式分包。</br>
4、Git许多命令不熟悉可能下载下来会有问题，可直接联系我Q群：551807041</br>




