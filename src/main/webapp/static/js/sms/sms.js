/**
 * Created by anzy on 2018/1/24.
 */

window.onload = function(){
    new Vue({
        el:"#box",
        data:{
            myData:[],
            tel:'',
            smsContent:'',
            cur: 1,
            all: 10,
            msg: ''
        },
        components:{
            'vue-nav': Vnav
        },
        methods:{
            add:function(){
                this.myData.push({
                    tel:this.tel,
                    smsContent:this.smsContent
                });
                //this.tel='';
                //this.smsContent='';
            },
            deleteMsg:function(index){
                this.myData.splice(index,1)
            },
            deleteAll:function(){
                this.myData = [];
            },
            query:function(){
                //查询方法
                alert("调用了查询！")
            },
            callback(data) {
                this.cur = data;
                this.msg = '你点击了'+data+ '页';
                //this.query();
            }

        }
    })
}