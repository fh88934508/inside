(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-machine-m_index"],{"13e3":function(t,e,n){"use strict";n.r(e);var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-uni-view",[n("uni-segmented-control",{attrs:{current:t.current,values:t.items,"style-type":"button","active-color":"#4cd964"},on:{clickItem:function(e){e=t.$handleEvent(e),t.onClickItem(e)}}}),n("v-uni-view",{staticStyle:{display:"flex","flex-direction":"row"}},[n("v-uni-view",[t._v(t._s(t.city)+t._s(t.villages)+t._s(t.Community))]),n("v-uni-button",{attrs:{type:"primary"},on:{click:function(e){e=t.$handleEvent(e),t.newselect(e)}}},[t._v("新增")])],1),n("v-uni-view",{staticClass:"content"},[n("uni-list",t._l(t.titleList,function(e,i){return n("v-uni-view",{key:i},[n("uni-list-item",{attrs:{title:e.title,"show-badge":"true","badge-text":e.count,disabled:"false"},on:{click:function(n){n=t.$handleEvent(n),t.onClick(e.title)}}})],1)}))],1)],1)},o=[],r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-uni-view",{staticClass:"segmented-control",class:t.styleType,style:t.wrapStyle},t._l(t.values,function(e,i){return n("v-uni-view",{key:i,staticClass:"segmented-control-item",class:t.styleType,style:i===t.currentIndex?t.activeStyle:t.itemStyle,on:{click:function(e){e=t.$handleEvent(e),t.onClick(i)}}},[t._v("\n\t\t"+t._s(e)+"\n\t")])}))},a=[],s={name:"uni-segmented-control",props:{current:{type:Number,default:0},values:{type:Array,default:function(){return[]}},activeColor:{type:String,default:"#007aff"},styleType:{type:String,default:"button"}},data:function(){return{currentIndex:this.current}},watch:{current:function(t){t!==this.currentIndex&&(this.currentIndex=t)}},computed:{wrapStyle:function(){var t="";switch(this.styleType){case"text":t="border:0;";break;default:t="border-color: ".concat(this.activeColor);break}return t},itemStyle:function(){var t="";switch(this.styleType){case"text":t="color:#000;border-left:0;";break;default:t="color:".concat(this.activeColor,";border-color:").concat(this.activeColor,";");break}return t},activeStyle:function(){var t="";switch(this.styleType){case"text":t="color:".concat(this.activeColor,";border-left:0;border-bottom-style:solid;");break;default:t="color:#fff;border-color:".concat(this.activeColor,";background-color:").concat(this.activeColor);break}return t}},methods:{onClick:function(t){this.currentIndex!==t&&(this.currentIndex=t,this.$emit("clickItem",t))}}},c=s,l=(n("53de"),n("2877")),u=Object(l["a"])(c,r,a,!1,null,"4805824a",null);u.options.__file="uni-segmented-control.vue";var d,f=u.exports,b=n("20bc"),p=n("76ad"),m={components:{uniSegmentedControl:f,uniList:b["a"],uniListItem:p["a"]},data:function(){return{items:["已选点","需地坪","待调试","待安装","已上线"],current:0,pagestep:0,city:"",villages:"",Community:"",orderno:"",titleList:[]}},methods:{onClickItem:function(t){this.current!==t&&(this.current=t),this.pagestep=0,this.city="",this.villages="",this.Community="",this.request()},onClick:function(t){var e=this,n=(this.pagestep,this.current);switch(e.pagestep){case 0:e.city=t;break;case 1:e.villages=t;break;case 2:e.Community=t;break;case 3:return uni.navigateTo({url:"/pages/machine/m_order?orderno="+t}),!1;default:console.log("步骤错误");break}uni.request({url:d,data:{current:n,pagestep:e.pagestep+1,city:e.city,villages:e.villages,Community:e.Community},method:"POST",header:{"content-type":"application/x-www-form-urlencoded","Access-Control-Allow-Origin":"*"},success:function(t){0==t.data.errcode&&(e.titleList=t.data.paramList,e.pagestep=e.pagestep+1)}})},newselect:function(){uni.navigateTo({url:"/pages/machine/m_select"})},request:function(){var t=this;d=this.websiteUrl+"/machine/TitleList",uni.request({url:d,data:{current:this.current,pagestep:0},method:"POST",header:{"content-type":"application/x-www-form-urlencoded","Access-Control-Allow-Origin":"*"},success:function(e){0==e.data.errcode&&(t.$data.titleList=e.data.paramList)}})}},onLoad:function(){this.request()}},v=m,h=(n("ab5a"),Object(l["a"])(v,i,o,!1,null,"fc97af06",null));h.options.__file="m_index.vue";e["default"]=h.exports},"1ab5":function(t,e,n){e=t.exports=n("2350")(!1),e.push([t.i,"\n.segmented-control[data-v-4805824a]{display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;-ms-flex-direction:row;flex-direction:row;-webkit-box-pack:center;-webkit-justify-content:center;-ms-flex-pack:center;justify-content:center;width:75%;font-size:%?28?%;border-radius:%?10?%;-webkit-box-sizing:border-box;box-sizing:border-box;margin:0 auto;overflow:hidden\n}\n.segmented-control.button[data-v-4805824a]{border:%?2?% solid\n}\n.segmented-control.text[data-v-4805824a]{border:0;border-radius:%?0?%\n}\n.segmented-control-item[data-v-4805824a]{-webkit-box-flex:1;-webkit-flex:1;-ms-flex:1;flex:1;text-align:center;line-height:%?60?%;-webkit-box-sizing:border-box;box-sizing:border-box\n}\n.segmented-control-item.button[data-v-4805824a]{border-left:%?1?% solid\n}\n.segmented-control-item.text[data-v-4805824a]{border-left:0\n}\n.segmented-control-item[data-v-4805824a]:first-child{border-left-width:0\n}",""])},2776:function(t,e,n){e=t.exports=n("2350")(!1),e.push([t.i,"",""])},"2b5f":function(t,e,n){var i=n("1ab5");"string"===typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);var o=n("4f06").default;o("7b9324a0",i,!0,{sourceMap:!1,shadowMode:!1})},"53de":function(t,e,n){"use strict";var i=n("2b5f"),o=n.n(i);o.a},"6aa1":function(t,e,n){var i=n("2776");"string"===typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);var o=n("4f06").default;o("d71d81f0",i,!0,{sourceMap:!1,shadowMode:!1})},ab5a:function(t,e,n){"use strict";var i=n("6aa1"),o=n.n(i);o.a}}]);