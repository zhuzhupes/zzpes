
import Vue from 'vue'
/* import App from './Appp' */
import plugins from './plugins/index.js'
/* console.log(plugins,'pulugins----------') */
// 这里的判断很重要
/* if (typeof window !== 'undefined' && window.Vue) { 
    window.Vue.use(plugins) 
} */
/* Vue.use(plugins)
newVue()
function newVue() {
	new Vue({
		el: '#app',		
		template: '<App/>',
		components: {
			App
		}
	})
} */
export default plugins;