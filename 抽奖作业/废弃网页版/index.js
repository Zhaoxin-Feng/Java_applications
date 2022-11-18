// 首先，定义一个数组，用于存放所有的背景图片
var arr = new Array();
// 将所有背景图放入arr内
arr.push('背景图地址', '背景图地址', '背景图地址');
// 随机获得一个键值
var bg = Math.floor((Math.random() * arr.length));
// 将背景图片放入body的css中
$('body').css('background-image', arr[bg]);