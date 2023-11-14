setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
                //data
                current: [],
                //others
                isLoading: false
            }
        },
        created() {
            this.getCurrent()
            this.getFavs()
        },
        methods: {
            getCurrent(){
                axios.get(`/api/getCurrent`)
                .then(res => {
                    this.current = res.data
                    console.log(this.current)
                }).catch(err => console.log(err))
            },
            getFavs(){
                axios.get(`/api/episodes/favs`)
                .then(res => {
                    this.favsEp = res.data
                    console.log(this.favsEp)
                }).catch(err => {
                    console.log(err)
                })
            }
        },
        computed: {
            
        }
    }).mount("#app")
}, 1000)