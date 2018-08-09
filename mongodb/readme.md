几个mongodbTemplate的使用注意事项。<br/>

1. save方法每条数据会自动保存id，如果自己设置了使用自己的。<br/>
  同时save的时候，如果id已经存在，会自动覆盖更新！<br/>
  insert方法如果id已经存在，则会直接报错！<br/>
  
2. 自带的remove方法也是如此，会根据id删除数据！<br/>
3. 
