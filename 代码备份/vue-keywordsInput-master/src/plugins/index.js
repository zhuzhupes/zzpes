const requireComponent = require.context('./',true,/\.vue$/) //路径，是否匹配子目录，正则
const install = (Vue, opts={})=>{
    if(install.installed) return
    install.installed
    requireComponent.keys().map(component => {
        const config = requireComponent(component)
        const componentName = config.default.name
        Vue.component(componentName,config.default || config)
    })
    /* Vue.prototype.$VUEQH = {
        size: opts.size || '',
        zindex:opts.zindex || 2000,
        type:opts.type || ''
    } */
}
// 这里的判断很重要
if (typeof window !== 'undefined' && window.Vue) { 
	window.Vue.use({install}) 
}
export default {
    install
}