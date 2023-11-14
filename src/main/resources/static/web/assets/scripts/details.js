setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
                current: [],
                episode: {},
                selectEp: [],
                comentaries: [],
                queryId: '',
                isLoading: false
            }
        },
        created() {
            this.getCurrent()
            this.queryId = new URLSearchParams(location.search).get('id')
            axios.get(`/api/episodes/${this.queryId}`)
                .then(res => {
                    this.episode = res.data
                    console.log(res.data)
                    this.comentaries = this.episode.comentarySet.sort((a, b) => a.id - b.id)
                    console.log(this.comentaries)
                }).catch(err => console.log(err))
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