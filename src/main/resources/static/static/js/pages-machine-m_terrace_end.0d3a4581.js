(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-machine-m_terrace_end"],{2620:function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-uni-view",[a("uni-list",{directives:[{name:"show",rawName:"v-show",value:!t.show,expression:"!show"}]},[a("uni-list-item",{attrs:{title:t.getorder_no,"show-arrow":"false"}}),a("uni-list-item",{attrs:{title:t.getselect_date,"show-arrow":"false"}}),a("uni-list-item",{attrs:{title:t.getcity,"show-arrow":"false"}}),a("uni-list-item",{attrs:{title:t.getvillages,"show-arrow":"false"}}),a("uni-list-item",{attrs:{title:t.getCommunity,"show-arrow":"false"}}),a("uni-list-item",{attrs:{title:t.getterrace,"show-arrow":"false"}}),a("uni-list-item",{attrs:{title:t.getterrace_progress,"show-arrow":"false"}}),a("uni-list-item",{attrs:{title:t.getlocation,"show-arrow":"true"},on:{click:function(e){e=t.$handleEvent(e),t.location(e)}}}),a("v-uni-text",{staticStyle:{"margin-left":"30upx","font-size":"30upx"}},[t._v(t._s(t.getremark))])],1),a("v-uni-view",{directives:[{name:"show",rawName:"v-show",value:!t.show,expression:"!show"}],staticClass:"buttonlist"},[a("v-uni-button",{attrs:{type:"primary"},on:{click:function(e){e=t.$handleEvent(e),t.done(e)}}},[t._v("完成")]),a("v-uni-button",{attrs:{type:"default"},on:{click:function(e){e=t.$handleEvent(e),t.install(e)}}},[t._v("安装中")]),a("v-uni-button",{attrs:{type:"warn"},on:{click:function(e){e=t.$handleEvent(e),t.repair(e)}}},[t._v("修复中")])],1),a("v-uni-view",{directives:[{name:"show",rawName:"v-show",value:t.show,expression:"show"}]},[a("v-uni-view",{staticClass:"remak"},[t._v(t._s(t.title))]),a("v-uni-view",{staticClass:"section"},[a("v-uni-form",{on:{submit:function(e){e=t.$handleEvent(e),t.updaterequest(e)}}},[a("v-uni-textarea",{attrs:{placeholder:"请输入备注",focus:t.focus,"auto-height":"",name:"remark",value:t.terraceremark},on:{click:function(e){e=t.$handleEvent(e),t.bindButtonTap(e)}}}),a("v-uni-view",{staticClass:"flex-direction"},[a("v-uni-button",{attrs:{type:"primary","form-type":"submit"}},[t._v("确定")]),a("v-uni-button",{attrs:{type:"warn"},on:{click:function(e){e=t.$handleEvent(e),t.cancel(e)}}},[t._v("取消")])],1)],1)],1)],1)],1)},r=[],s=a("20bc"),n=a("76ad"),o={components:{uniList:s["a"],uniListItem:n["a"]},data:function(){return{id:"",select_date:"",order_no:"",villages:"",city:"",Community:"",remark:"",show:!1,focus:!0,step:"",title:"",longitude:"",latitude:"",terrace:"",terracestep:"",terraceremark:"",terrace_progress:""}},computed:{getorder_no:function(){return"单号:   "+this.order_no},getselect_date:function(){return"选点确认时间："+this.select_date},getvillages:function(){return"街道（乡镇）:"+this.villages},getcity:function(){return"县（市）:"+this.city},getCommunity:function(){return"小区:"+this.Community},getremark:function(){return"选点确认备注："+this.remark},getlocation:function(){return"经度:"+this.longitude+"纬度:"+this.latitude},getterrace_progress:function(){return"地坪进度:"+this.terrace_progress},getterrace:function(){var t;switch(this.terrace){case"0":t="安装进度：无需安装";break;case"1":t="安装进度：待安装";break;case"2":t="安装进度：安装中";break;case"3":t="安装进度：修复中";break;case"4":t="安装进度：已完成";break}return t}},methods:{done:function(){this.show=!this.show,this.step="4",this.terracestep="已完成"},install:function(){this.show=!this.show,this.terracestep="安装中"},repair:function(){this.show=!this.show,this.terracestep="修复中"},cancel:function(){this.show=!this.show},updaterequest:function(t){var e=this;uni.request({url:this.websiteUrl+"/machine/updateterrace",data:{id:this.id,terracestep:this.terracestep,remark:t.detail.value.remark,step:this.step},success:function(t){console.log(t.data),uni.navigateTo({url:"/pages/machine/m_succee?id="+e.id+"&title=地坪状态修改成功&step="+e.step})}})}},onLoad:function(t){var e=this;this.id=t.id,uni.request({url:this.websiteUrl+"/machine/terrace",data:{id:this.id,step:3,terracestep:this.terracestep},success:function(t){e.id=t.data.paramMap.id,e.select_date=t.data.paramMap.select_v_date,e.order_no=t.data.paramMap.order_no,e.city=t.data.paramMap.city,e.villages=t.data.paramMap.villages,e.Community=t.data.paramMap.Community,e.remark=t.data.paramMap.select_v_remark,e.longitude=t.data.paramMap.longitude,e.latitude=t.data.paramMap.latitude,e.terrace=t.data.paramMap.terrace_progress,e.step=t.data.paramMap.step,e.terraceremark=t.data.paramMap.terrace_remark,e.terrace_progress=t.data.paramMap.terrace_progress},fail:function(t){console.log(t.data)}})}},c=o,l=(a("f127"),a("2877")),u=Object(l["a"])(c,i,r,!1,null,"1ce73a1f",null);u.options.__file="m_terrace_end.vue";e["default"]=u.exports},"32f6":function(t,e,a){e=t.exports=a("2350")(!1),e.push([t.i,"\n.title[data-v-1ce73a1f]{margin-top:%?150?%;text-align:center\n}\n.buttonlist[data-v-1ce73a1f]{margin-top:%?150?%;display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;-ms-flex-direction:row;flex-direction:row\n}\n.remak[data-v-1ce73a1f]{text-align:center;margin:%?20?% %?20?% %?20?% %?20?%\n}\nuni-textarea[data-v-1ce73a1f]{background-color:#eee;width:%?750?%\n}",""])},"5f07":function(t,e,a){var i=a("32f6");"string"===typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);var r=a("4f06").default;r("88d5cf02",i,!0,{sourceMap:!1,shadowMode:!1})},f127:function(t,e,a){"use strict";var i=a("5f07"),r=a.n(i);r.a}}]);