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
        },
        methods: {
            getCurrent(){
                axios.get(`/api/getCurrent`)
                .then(res => {
                    this.current = res.data
                    console.log(this.current)
                }).catch(err => console.log(err))
            }
        },
        computed: {
            
        }
    }).mount("#app")
}, 1000)