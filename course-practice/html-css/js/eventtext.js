  import { printLog } from "./utils1.js";
  
  document.querySelector("button").addEventListener("click",()=>{
            printLog("点我了");
        })

        document.querySelector("#name").addEventListener("keydown",()=>{
            printLog("按下了键");
        })
        
        document.querySelector("#name").addEventListener("keyup",()=>{
            printLog("松开了键");
        })

        document.querySelector("#name").addEventListener("blur",()=>{
            printLog("失去焦点");
        })
        document.querySelector("#name").addEventListener("focus",()=>{
            printLog("获得焦点");
        })  

        document.querySelector("#name").addEventListener("input",()=>{
            printLog("输入了内容");
        }) 

        //submit事件 提交表单时触发
        document.querySelector("form").addEventListener("submit",()=>{
            printLog("提交了");
        })  
        //为什么点了提交会跳转页面
        //因为提交表单时,会默认将表单中的数据发送到服务器,,
        //所以需要在提交表单时,阻止默认行为,防止跳转页面
        //这个e是什么意思? 事件对象,用于阻止事件默认行为

        document.querySelector("form").addEventListener("submit",(e)=>{
            e.preventDefault();
        }) 