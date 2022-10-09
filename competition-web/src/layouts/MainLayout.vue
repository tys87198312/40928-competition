
<template>
  <q-layout view="hHh LpR fFf">

    <q-header reveal elevated class="bg-primary text-white" height-hint="98">
      <q-toolbar>
        <q-btn dense flat round icon="menu" @click="toggleLeftDrawer" />

        <q-toolbar-title>
          <q-avatar>
            <img src="https://cdn.quasar.dev/logo-v2/svg/logo-mono-white.svg">
          </q-avatar>
          TITLE
          <q-btn color="brown-5" icon="directions" size="sm" padding="10px" class="float-right" @click="loginOut">
            <q-tooltip class="bg-accent">退出登录</q-tooltip>
          </q-btn>
          <q-chip class="float-right">
            <q-avatar >
              <img src="boy-avatar.png">
            </q-avatar>
            {{name}}
          </q-chip>

        </q-toolbar-title>

        <q-btn dense flat round icon="menu" @click="toggleRightDrawer" />
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      show-if-above
      bordered
    >
      <q-list>
        <EssentialLink
          v-for="link in essentialLinks"
          :key="link.title"
          v-bind="link"
        />
      </q-list>
    </q-drawer>

    <q-drawer show-if-above v-model="rightDrawerOpen" side="right" elevated width=200>
      <q-card style="height: 100%">
        <q-card-section tag="div" style="height: 100%">
          <h6 class="text-left">总分排行</h6>
          <q-list>
            <q-item dense v-for="(item) in details" :key="item" class="items-lg-center">
              <div class="text-overline">{{item.userName}} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{item.score == null? '0分' : item.score + '分'}}</div>
            </q-item>
          </q-list>
        </q-card-section >
      </q-card>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
  import { defineComponent, ref, getCurrentInstance,reactive  } from 'vue'
  import EssentialLink from 'components/EssentialLink.vue'
  import { useCounterStore } from 'stores/global';
  import { useRoute, useRouter } from 'vue-router'

  let linksList = []

  export default defineComponent({
    name: 'MainLayout',
    components: {
      EssentialLink
    },
    setup () {
      const { proxy } = getCurrentInstance()
      const router = useRouter()
      const store = useCounterStore();
      const leftDrawerOpen = ref(true)
      const rightDrawerOpen = ref(true)
      const name = store.user.name
      const roleName = store.user.roleName
      let details = ref([])


      if (roleName == '系统管理员') {
        linksList = [{
          title: '用户管理',
          icon: 'school',
          link: 'UserManager'
        }]
      } else if (roleName == '主办方') {
        linksList = [{
          title: '比赛管理',
          icon: 'school',
          link: 'Competition'
        }]
      } else if (roleName == '评委') {
        linksList = [
          {
          title: '比赛大厅(评委)',
          icon: 'school',
          link: 'CompetitionPW'
          },
          {
            title: '我的比赛(评委)',
            icon: 'school',
            link: 'CompetitionJoinPW'
          }]
      } else {
        linksList = [
          {
            title: '比赛大厅(选手)',
            icon: 'school',
            link: 'CompetitionXS'
          },
          {
            title: '我的比赛(选手)',
            icon: 'school',
            link: 'CompetitionJoinXS'
          }]
      }


      function loginOut () {
        store.$reset()
        router.push('/login')
      }

      function detail () {
        proxy.$api.defaults.headers.common['Authorization'] = store.user.token
        proxy.$api.get('competition/sort')
          .then((response) => {
            let result = response.data
            /*结果校验*/
            if (result.code != '200') {
              this.$q.notify({
                message: result.msg,
                color: 'red',
                position: 'top'
              })
              return
            }
            details.value = result.data
            console.log(details.value)
        })
      }
      detail()
      console.log(details.value)
      return {
        detail,
        loginOut,
        name,
        details,
        essentialLinks: linksList,
        leftDrawerOpen,
        rightDrawerOpen,
        toggleLeftDrawer () {
          leftDrawerOpen.value = !leftDrawerOpen.value
        },
        toggleRightDrawer () {
          rightDrawerOpen.value = !rightDrawerOpen.value
        }
      }
    }
  })
</script>
