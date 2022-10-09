<template>
  <q-layout>
    <q-page-container>
      <q-page class="flex bg-image flex-center">
        <q-card v-bind:style="$q.screen.lt.sm?{'width': '80%'}:{'width':'30%'}">
          <q-card-section>
            <q-avatar size="103px" class="absolute-center shadow-10">
              <img src="profile.svg">
            </q-avatar>
          </q-card-section>
          <q-card-section>
            <div class="text-center q-pt-lg">
              <div class="col text-h6 ellipsis">
                Log in
              </div>
            </div>
          </q-card-section>
          <q-card-section>
            <q-form  @submit="onSubmit" @reset="onRest" ref="loginForm"
              class="q-gutter-md"
            >
              <q-input
                filled
                v-model="user.username"
                label="账号"
                lazy-rules
              />

              <q-input
                type="password"
                filled
                v-model="user.password"
                label="密码"
                lazy-rules

              />

              <div>
                <q-btn label="登录"  type="submit" color="primary"/>
                <q-btn label="重置"  type="reset" color="primary"/>
              </div>
            </q-form>
          </q-card-section>
        </q-card>
      </q-page>
    </q-page-container>
  </q-layout>
</template>

<script>
  import { useCounterStore } from 'stores/global';
  import {api} from "../boot/axios";
  const store = useCounterStore();
    export default  {
      name: 'login',
      data () {
        return {
          user: {
            username: null,
            password: null,
            clientId: 'common'
          }
        }
      },
      created() {
        this.user.username = null
        this.user.password = null
      },
      methods: {
        onSubmit () {
          this.$refs.loginForm.validate().then(() => {
            this.$api.post('login', this.user)
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
              this.$api.defaults.headers.common['Authorization'] = result.data.token
              store.$patch({
                user:{
                  userId: result.data.userid,
                  userName: result.data.userName,
                  token: result.data.token,
                  roleName: result.data.roleName,
                  name: result.data.name
                }
              })
              console.log('登录成功： ', store.user)
              console.log('userId', store.user.userId)
              this.$router.push('/')
            })

          })
        },
        onRest () {
          this.user.username = null
          this.user.password = null
          this.$refs.loginForm.resetValidation()
          this.$q.notify({
            message: '重置成功',
            position: 'top',
            color: 'blue'
          })
        }
      }
    }
</script>

<style scoped>
  .bg-image {
    background-image: linear-gradient(135deg, #1759e4 0%, #8ebae5 100%);
    /*background-image: linear-gradient(135deg, #7028e4 0%, #e5b2ca 100%);*/
  }
</style>
