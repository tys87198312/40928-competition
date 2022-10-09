import { route } from 'quasar/wrappers'
import { createRouter, createMemoryHistory, createWebHistory, createWebHashHistory } from 'vue-router'
import routes from './routes'
import { useCounterStore } from 'stores/global';

// import { useCounterStore } from 'stores/global';
// import de from "quasar/lang/de";
// const store = useCounterStore();

/*
 * If not building with SSR mode, you can
 * directly export the Router instantiation;
 *
 * The function below can be async too; either use
 * async/await or return a Promise which resolves
 * with the Router instance.
 */

export default route(function () {
  const createHistory = process.env.SERVER
    ? createMemoryHistory
    : (process.env.VUE_ROUTER_MODE === 'history' ? createWebHistory : createWebHashHistory)

  const Router = createRouter({
    scrollBehavior: () => ({ left: 0, top: 0 }),
    routes,

    // Leave this as is and make changes in quasar.conf.js instead!
    // quasar.conf.js -> build -> vueRouterMode
    // quasar.conf.js -> build -> publicPath
    history: createHistory(process.env.MODE === 'ssr' ? void 0 : process.env.VUE_ROUTER_BASE)
  })
  // 安装路由权限验证
  Router.beforeEach((to, from, next) => {
    // 这个不能放在上面执行（加载顺序）
    const store = useCounterStore();
    const path = to.path
    console.log('Router.beforeEach => ', store.user.userId)
    if (store.user.userId) {
      // 若已登录
      // 把路径保存到历史中
      // store.dispatch('route/addPath', path)
      next()
    } else {
      // 若未登录，则必须登录
      if (path === '/login') {
        next()
      } else {
        next('/login')
      }
    }
  })


  return Router
})
