setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
                current: [],
                featuredEp: [],
                featuredAr: [],
                isLoading: false
            }
        },
        created() {
            this.getCurrent()
            this.getArFeatured()
            this.getEpFeatured()
        },
        methods: {
            getCurrent() {
                axios.get(`/api/getCurrent`)
                    .then(res => {
                        this.current = res.data
                    }).catch(err => console.log(err))
            },
            getArFeatured() {
                axios.get(`/api/archives/featured`)
                    .then(res => {
                        this.featuredAr = res.data
                    }).catch(err => console.log(err))
            },
            getEpFeatured() {
                axios.get(`/api/episodes/featured`)
                    .then(res => {
                        this.featuredEp = res.data.sort((a, b) => b.id - a.id)
                    }).catch(err => console.log(err))
            }
        },
        computed: {
        }
    }).mount("#app")
}, 1000)